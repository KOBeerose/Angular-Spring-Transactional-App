package com.example.ContractService.controllerService;

import com.example.ContractService.AnnonceContract.AnnonceContract;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import java.math.BigDecimal;
import java.math.BigInteger;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class controllerService {
    Web3j web3j= Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));
    private static BigInteger GAS_LIMIT= BigInteger.valueOf(6721975L);
    private static BigInteger GAS_PRICE =BigInteger.valueOf(20000000000L);

    private String deployContract(Web3j web3j,TransactionManager transactionManager) throws Exception {

        return AnnonceContract.deploy(web3j,transactionManager,GAS_PRICE,GAS_LIMIT).send().getContractAddress();
    }


    @PostMapping("/DeployContract")
    public void  DeployContract() throws Exception {
        TransactionManager transactionManager = new RawTransactionManager(
                web3j,
                getCredentialsFromPrivateKey("4f9b4c9cc59eb7848a5bce96ed00e28cb8cd2a148788fd99096a0e73ad30c441")
        );
        String deployedAddress = deployContract(web3j,transactionManager);
        System.out.println("**********************");
    }

    private AnnonceContract loadContract(Web3j web3j, TransactionManager transactionManager){
        //CONTRACT_ADDRESS
        String contractAddress="0x2CE597e09a8408fd2D19Eac2A1fE05eFE4225Ecb";
        return AnnonceContract.load(contractAddress,web3j,transactionManager,GAS_PRICE,GAS_LIMIT);
    }
    @PostMapping("/addImmobilier")
    public void addImmobilier(@RequestBody ImmobilierAnn immobilierAnn) throws Exception {
        System.out.println("owner :"+immobilierAnn.getOwnerAddress()+" Price: "+immobilierAnn.getPrice()+"Titre: "+immobilierAnn.getTitre());
        TransactionManager transactionManager = new RawTransactionManager(
                //miner is static, he's always the owner
                web3j,getCredentialsFromPrivateKey("4f9b4c9cc59eb7848a5bce96ed00e28cb8cd2a148788fd99096a0e73ad30c441") );
        AnnonceContract annonceContract=loadContract(web3j,transactionManager);
        annonceContract.addImmobilier(immobilierAnn.getOwnerAddress(),immobilierAnn.getTitre()).send();
        System.out.println("Immobiler added");
    }

    private static Credentials getCredentialsFromPrivateKey(String P) {
        return Credentials.create(P);
    }



    @PostMapping("/transfertEher")
    public boolean transfertEher(@RequestBody ImmobilierAnn immobilierAnn) throws Exception {
        TransactionManager transactionManager=new RawTransactionManager(
                web3j,
                getCredentialsFromPrivateKey(immobilierAnn.getRecipentPrivateKey())
        );
        //get Ether of an account
        EthGetBalance ethGetBalance = web3j
                .ethGetBalance(immobilierAnn.getRecipentAddress(), DefaultBlockParameterName.LATEST)
                .sendAsync()
                .get();
        //Convert BgInteger to Ether
        BigDecimal amountWei=Convert.fromWei(ethGetBalance.getBalance().toString(), Convert.Unit.ETHER);
        System.out.println("after: "+ethGetBalance.getBalance());
        System.out.println("befor: "+amountWei);

        if(amountWei.compareTo(BigDecimal.valueOf(Double.valueOf(immobilierAnn.getPrice())))==1){
            Transfer transfer=new Transfer(web3j,transactionManager);
            TransactionReceipt transactionReceipt=transfer.sendFunds(
                    immobilierAnn.getOwnerAddress(),
                    BigDecimal.valueOf(Double.parseDouble(immobilierAnn.getPrice())),
                    Convert.Unit.ETHER,
                    GAS_PRICE,
                    GAS_LIMIT
            ).send();
            return true;
        }
        return false;

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/transferImmobilier")
    public HttpEntity<Boolean> transferImmobilier(@RequestBody ImmobilierAnn immobilierAnn) throws Exception {
       // System.out.println(immobilierAnn.getTitre());
        TransactionManager transactionManager=new RawTransactionManager(
                web3j,
                getCredentialsFromPrivateKey(immobilierAnn.getRecipentPrivateKey())
        );
        if (!this.transfertEher(immobilierAnn)) return new HttpEntity<>(false);
        System.out.println("DONE");
        AnnonceContract annonceContract=loadContract(web3j,transactionManager);
        annonceContract.transferImmobilier(immobilierAnn.getRecipentAddress(),immobilierAnn.getOwnerAddress(),immobilierAnn.getTitre()).send();
        System.out.println("Immobilier trasferer with success");
        double a=Double.parseDouble(immobilierAnn.getPrice());
        a=a*0.05;
        immobilierAnn.setPrice(Double.toString(a));
        immobilierAnn.setOwnerAddress("0x0EF1B12C275F6a721EA5ae1300842e166dbFaF77");
        if (!this.transfertEher(immobilierAnn)) return new HttpEntity<>(false);;
        return new HttpEntity<>(true);
    }

}

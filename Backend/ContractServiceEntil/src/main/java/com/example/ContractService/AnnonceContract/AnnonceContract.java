package com.example.ContractService.AnnonceContract;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class AnnonceContract extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b50610e69806100206000396000f3fe60806040526004361061003f5760003560e01c806354eefe9c1461004457806363a39d9514610082578063ad1dac33146100ab578063bed34bba146100db575b600080fd5b34801561005057600080fd5b5061006b60048036038101906100669190610912565b610118565b6040516100799291906109fa565b60405180910390f35b34801561008e57600080fd5b506100a960048036038101906100a49190610b5f565b610201565b005b6100c560048036038101906100c09190610bbb565b61033c565b6040516100d29190610c45565b60405180910390f35b3480156100e757600080fd5b5061010260048036038101906100fd9190610c60565b61072e565b60405161010f9190610c45565b60405180910390f35b6000602052816000526040600020818154811061013457600080fd5b9060005260206000209060020201600091509150508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169080600101805461017e90610d07565b80601f01602080910402602001604051908101604052809291908181526020018280546101aa90610d07565b80156101f75780601f106101cc576101008083540402835291602001916101f7565b820191906000526020600020905b8154815290600101906020018083116101da57829003601f168201915b5050505050905082565b600060405180604001604052808473ffffffffffffffffffffffffffffffffffffffff1681526020018381525090506000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081908060018154018082558091505060019003906000526020600020906002020160009091909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010190805190602001906102fb929190610787565b5050507f642fae9d0bdca764daf250fc90831d6e88318a4ce78836d46fbbf63c282c6c20338360405161032f9291906109fa565b60405180910390a1505050565b600080600090505b6000808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002080549050811015610721576104806000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002082815481106103e0576103df610d39565b5b906000526020600020906002020160010180546103fc90610d07565b80601f016020809104026020016040519081016040528092919081815260200182805461042890610d07565b80156104755780601f1061044a57610100808354040283529160200191610475565b820191906000526020600020905b81548152906001019060200180831161045857829003601f168201915b50505050508461072e565b1561070e57600060405180604001604052808773ffffffffffffffffffffffffffffffffffffffff1681526020016000808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002084815481106104fe576104fd610d39565b5b9060005260206000209060020201600101805461051a90610d07565b80601f016020809104026020016040519081016040528092919081815260200182805461054690610d07565b80156105935780601f1061056857610100808354040283529160200191610593565b820191906000526020600020905b81548152906001019060200180831161057657829003601f168201915b505050505081525090506000808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081908060018154018082558091505060019003906000526020600020906002020160009091909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506020820151816001019080519060200190610668929190610787565b5050506000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002082815481106106bb576106ba610d39565b5b9060005260206000209060020201600080820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff0219169055600182016000610701919061080d565b5050600192505050610727565b808061071990610d97565b915050610344565b50600090505b9392505050565b6000816040516020016107419190610e1c565b60405160208183030381529060405280519060200120836040516020016107689190610e1c565b6040516020818303038152906040528051906020012014905092915050565b82805461079390610d07565b90600052602060002090601f0160209004810192826107b557600085556107fc565b82601f106107ce57805160ff19168380011785556107fc565b828001600101855582156107fc579182015b828111156107fb5782518255916020019190600101906107e0565b5b509050610809919061084d565b5090565b50805461081990610d07565b6000825580601f1061082b575061084a565b601f016020900490600052602060002090810190610849919061084d565b5b50565b5b8082111561086657600081600090555060010161084e565b5090565b6000604051905090565b600080fd5b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006108a98261087e565b9050919050565b6108b98161089e565b81146108c457600080fd5b50565b6000813590506108d6816108b0565b92915050565b6000819050919050565b6108ef816108dc565b81146108fa57600080fd5b50565b60008135905061090c816108e6565b92915050565b6000806040838503121561092957610928610874565b5b6000610937858286016108c7565b9250506020610948858286016108fd565b9150509250929050565b61095b8161089e565b82525050565b600081519050919050565b600082825260208201905092915050565b60005b8381101561099b578082015181840152602081019050610980565b838111156109aa576000848401525b50505050565b6000601f19601f8301169050919050565b60006109cc82610961565b6109d6818561096c565b93506109e681856020860161097d565b6109ef816109b0565b840191505092915050565b6000604082019050610a0f6000830185610952565b8181036020830152610a2181846109c1565b90509392505050565b600080fd5b600080fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b610a6c826109b0565b810181811067ffffffffffffffff82111715610a8b57610a8a610a34565b5b80604052505050565b6000610a9e61086a565b9050610aaa8282610a63565b919050565b600067ffffffffffffffff821115610aca57610ac9610a34565b5b610ad3826109b0565b9050602081019050919050565b82818337600083830152505050565b6000610b02610afd84610aaf565b610a94565b905082815260208101848484011115610b1e57610b1d610a2f565b5b610b29848285610ae0565b509392505050565b600082601f830112610b4657610b45610a2a565b5b8135610b56848260208601610aef565b91505092915050565b60008060408385031215610b7657610b75610874565b5b6000610b84858286016108c7565b925050602083013567ffffffffffffffff811115610ba557610ba4610879565b5b610bb185828601610b31565b9150509250929050565b600080600060608486031215610bd457610bd3610874565b5b6000610be2868287016108c7565b9350506020610bf3868287016108c7565b925050604084013567ffffffffffffffff811115610c1457610c13610879565b5b610c2086828701610b31565b9150509250925092565b60008115159050919050565b610c3f81610c2a565b82525050565b6000602082019050610c5a6000830184610c36565b92915050565b60008060408385031215610c7757610c76610874565b5b600083013567ffffffffffffffff811115610c9557610c94610879565b5b610ca185828601610b31565b925050602083013567ffffffffffffffff811115610cc257610cc1610879565b5b610cce85828601610b31565b9150509250929050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b60006002820490506001821680610d1f57607f821691505b60208210811415610d3357610d32610cd8565b5b50919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6000610da2826108dc565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff821415610dd557610dd4610d68565b5b600182019050919050565b600081905092915050565b6000610df682610961565b610e008185610de0565b9350610e1081856020860161097d565b80840191505092915050565b6000610e288284610deb565b91508190509291505056fea26469706673582212209db2de629d5882e55ff3638e0e5b8f733457e9f54495d37e2654ed05d8b35fdd64736f6c634300080a0033";

    public static final String FUNC___OWNERIMMOBILIERS = "__ownerImmobiliers";

    public static final String FUNC_ADDIMMOBILIER = "addImmobilier";

    public static final String FUNC_COMPARESTRINGS = "compareStrings";

    public static final String FUNC_TRANSFERIMMOBILIER = "transferImmobilier";

    public static final Event ADD_EVENT = new Event("Add", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected AnnonceContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AnnonceContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AnnonceContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AnnonceContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AddEventResponse> getAddEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADD_EVENT, transactionReceipt);
        ArrayList<AddEventResponse> responses = new ArrayList<AddEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddEventResponse typedResponse = new AddEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._N_titre = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddEventResponse> addEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AddEventResponse>() {
            @Override
            public AddEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADD_EVENT, log);
                AddEventResponse typedResponse = new AddEventResponse();
                typedResponse.log = log;
                typedResponse._owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._N_titre = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddEventResponse> addEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADD_EVENT));
        return addEventFlowable(filter);
    }

    public RemoteFunctionCall<Tuple2<String, String>> __ownerImmobiliers(String param0, BigInteger param1) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC___OWNERIMMOBILIERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple2<String, String>>(function,
                new Callable<Tuple2<String, String>>() {
                    @Override
                    public Tuple2<String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> addImmobilier(String propertyOwner, String _N_titre) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDIMMOBILIER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(propertyOwner), 
                new org.web3j.abi.datatypes.Utf8String(_N_titre)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> compareStrings(String str1, String str2) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_COMPARESTRINGS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(str1), 
                new org.web3j.abi.datatypes.Utf8String(str2)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferImmobilier(String _Buyer, String _propertyOwner, String _N_titre) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERIMMOBILIER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_Buyer), 
                new org.web3j.abi.datatypes.Address(_propertyOwner), 
                new org.web3j.abi.datatypes.Utf8String(_N_titre)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static AnnonceContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AnnonceContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AnnonceContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AnnonceContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AnnonceContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AnnonceContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AnnonceContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AnnonceContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AnnonceContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AnnonceContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AnnonceContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AnnonceContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AnnonceContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AnnonceContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AnnonceContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AnnonceContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class AddEventResponse extends BaseEventResponse {
        public String _owner;

        public String _N_titre;
    }
}

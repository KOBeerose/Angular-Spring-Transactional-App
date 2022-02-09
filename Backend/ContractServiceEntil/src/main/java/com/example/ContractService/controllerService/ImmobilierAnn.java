package com.example.ContractService.controllerService;

import java.math.BigInteger;

public class ImmobilierAnn {

    private String ownerAddress;
    private String recipentAddress;
    private String titre;
    private String price;
    private String ownerPrivateKey;
    private String recipentPrivateKey;

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public void setRecipentAddress(String recipentAddress) {
        this.recipentAddress = recipentAddress;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setOwnerPrivateKey(String ownerPrivateKey) {
        this.ownerPrivateKey = ownerPrivateKey;
    }

    public void setRecipentPrivateKey(String recipentPrivateKey) {
        this.recipentPrivateKey = recipentPrivateKey;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public String getRecipentAddress() {
        return recipentAddress;
    }

    public String getTitre() {
        return titre;
    }

    public String getPrice() {
        return price;
    }

    public String getOwnerPrivateKey() {
        return ownerPrivateKey;
    }

    public String getRecipentPrivateKey() {
        return recipentPrivateKey;
    }
}

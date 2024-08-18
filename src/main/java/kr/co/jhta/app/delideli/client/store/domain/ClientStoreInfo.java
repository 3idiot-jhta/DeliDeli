package kr.co.jhta.app.delideli.client.store.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClientStoreInfo {
    private int storeInfoKey;
    private int clientKey;
    private String storeName;
    private String storeAddress;
    private String storeZipcode;
    private String storeAddrDetail;
    private String storePhone;
    private int minOrderAmount;
    private int orderAmount1;
    private int deliveryAmount1;
    private Integer orderAmount2;
    private Integer deliveryAmount2;
    private Integer orderAmount3;
    private Integer deliveryAmount3;
    private String openTime;
    private String closeTime;
    private String storeDetailInfo;
    private String storeOriginInfo;
    private String storeBusinessRegistrationFile;
    private String storeBusinessReportFile;
    private String storeProfileImg;
    private boolean storeAccess;
    private boolean storeDelete;
    private boolean storePause;
    private LocalDateTime storeRegdate;
    private LocalDateTime storeUpdate;
}

package com.orlovandrei.atm.repository;

import com.orlovandrei.atm.entity.CardData;

import java.time.LocalDateTime;
import java.util.List;

public interface CardRepository {
    CardData createCardDataFromFileData(String[] data);
    void updateCardData(CardData cardData);
    boolean cardExists(String cardNumber, List<String[]> dataList);
    LocalDateTime parseDateTime(String dateTimeString);
}

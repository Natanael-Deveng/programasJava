package com.example.csvloader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvLoader {
	
	static class CsvRow {
	    int type;
	    int rowNumber;
	    boolean deletePosition;
	    int participantName;
	    int accountName;
	    LocalDate tradeDate;
	    int sideAuto;
	    int btcTradeId;
	    long securityIdOfUnderlying;
	    LocalDate unlockDate;
	    LocalDate expirateDate;

	    public String getContractNumber() {
	        return String.format("%s00%d0001-1", tradeDate.toString().replace("-", ""), btcTradeId);
	    }

	    @Override
	    public String toString() {
	        return String.join(";",
	                String.valueOf(type),
	                String.valueOf(rowNumber),
	                String.valueOf(deletePosition),
	                String.valueOf(participantName),
	                String.valueOf(accountName),
	                tradeDate.toString(),
	                getContractNumber(),
	                String.valueOf(sideAuto),
	                String.valueOf(btcTradeId),
	                String.valueOf(securityIdOfUnderlying),
	                unlockDate.toString(),
	                expirateDate.toString()
	        );
	    }
	}
	
	private static List<CsvRow> generateSampleRows(int count) {
	    List<CsvRow> rows = new ArrayList<>();
	    for (int i = 1; i <= count; i++) {
	        CsvRow row = new CsvRow();
	        row.type = i % 2;
	        row.rowNumber = i;
	        row.deletePosition = i % 2 == 0;
	        row.participantName = 1000 + i;
	        row.accountName = 2000 + i;
	        row.tradeDate = LocalDate.of(2022, 11, 20).plusDays(i);
	        row.sideAuto = 1;
	        row.btcTradeId = i;
	        row.securityIdOfUnderlying = 100000L + i;
	        row.unlockDate = row.tradeDate.plusMonths(1);
	        row.expirateDate = row.tradeDate.plusYears(1);

	        rows.add(row);
	    }
	    return rows;
	}


	public static void main(String[] args) {
	    List<CsvRow> rows = generateSampleRows(10);

	    String fileName = "loader.csv";

	    try (FileWriter writer = new FileWriter(fileName)) {
	        writer.write("Type;rowNumber;Delete Position;participantName;accountName;Trade Date;Contract Number;Side (Auto);BTC Trade Id;Security Id of underlying;Unlock Date;Expirate Date\n");

	        for (CsvRow row : rows) {
	            writer.write(row.toString() + "\n");
	        }

	        System.out.println("Arquivo CSV gerado com sucesso: " + fileName);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


}

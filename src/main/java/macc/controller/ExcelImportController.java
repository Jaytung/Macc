package macc.controller;

import com.opencsv.CSVReader;
import macc.dao.BillingDataRepository;
import macc.entity.Billingdata;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping("/macc")
public class ExcelImportController {

	@Autowired
	private BillingDataRepository billingDataRepository;

	@PostMapping("/import")
	public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

		if (!file.isEmpty()) {
			String originalFilename = file.getOriginalFilename();
			if (originalFilename != null) {
				if (originalFilename.endsWith(".csv")) {
					try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream(), "Big5"))) {
						String[] nextLine;
						reader.readNext(); // 跳过CSV文件的标题行

						List<Billingdata> batch = new ArrayList<>();
						int batchSize = 0;

						while ((nextLine = reader.readNext()) != null) {
							// 在這裡處理 CSV 行的內容
							// 確保 Billingdata 物件屬性和 CSV 欄位的對應是正確的
							Billingdata billingdata = new Billingdata();
							billingdata.setBillingaccountid(nextLine[0]);
							billingdata.setBillingaccountname(nextLine[1]);
							billingdata.setBillingperiodstartdate(nextLine[2]);
							billingdata.setBillingperiodenddate(nextLine[3]);
							billingdata.setBillingprofileid(nextLine[4]);
							billingdata.setBillingprofilename(nextLine[5]);
							billingdata.setAccountownerid(nextLine[6]);
							billingdata.setAccountname(nextLine[7]);
							billingdata.setSubscriptionid(nextLine[8]);
							billingdata.setSubscriptionname(nextLine[9]);
							billingdata.setDate(nextLine[10]);
							billingdata.setProduct(nextLine[11]);
							billingdata.setPartnumber(nextLine[12]);
							billingdata.setMeterid(nextLine[13]);
							billingdata.setServicefamily(nextLine[14]);
							billingdata.setMetercategory(nextLine[15]);
							billingdata.setMetersubcategory(nextLine[16]);
							billingdata.setMeterregion(nextLine[17]);
							billingdata.setMetername(nextLine[18]);
							if (!nextLine[19].isEmpty()) {
								billingdata.setQuantity(Double.parseDouble(nextLine[19]));
							} else {
								billingdata.setQuantity(0.0);
							}
							if (!nextLine[20].isEmpty()) {
								billingdata.setEffectiveprice(Double.parseDouble(nextLine[20]));
							} else {
								billingdata.setEffectiveprice(0.0);
							}
							if (!nextLine[21].isEmpty()) {
								billingdata.setCost(Double.parseDouble(nextLine[21]));
							} else {
								billingdata.setCost(0.0);
							}
							if (!nextLine[22].isEmpty()) {
								billingdata.setUnitprice(Double.parseDouble(nextLine[22]));
							} else {
								billingdata.setUnitprice(0.0);
							}
							if (!nextLine[23].isEmpty()) {
								billingdata.setAllcost(Double.parseDouble(nextLine[23]));
							} else {
								billingdata.setAllcost(0.0);
							}
							billingdata.setBillingcurrency(nextLine[24]);
							billingdata.setResourcelocation(nextLine[25]);
							billingdata.setAvailabilityzone(nextLine[26]);
							billingdata.setConsumedservice(nextLine[27]);
							billingdata.setResourceid(nextLine[28]);
							billingdata.setResourcename(nextLine[29]);
							billingdata.setServiceinfo1(nextLine[30]);
							billingdata.setServiceinfo2(nextLine[31]);
							billingdata.setAdditionalinfo(nextLine[32]);
							billingdata.setTags(nextLine[33]);
							billingdata.setInvoicesectionid(nextLine[34]);
							billingdata.setInvoicesection(nextLine[35]);
							billingdata.setCostcenter(nextLine[36]);
							billingdata.setUnitofmeasure(nextLine[37]);
							billingdata.setResourcegroup(nextLine[38]);
							billingdata.setReservationid(nextLine[39]);
							billingdata.setReservationname(nextLine[40]);
							billingdata.setProductorderid(nextLine[41]);
							billingdata.setProductordername(nextLine[42]);
							billingdata.setOfferid(nextLine[43]);
							billingdata.setIsazurecrediteligible(nextLine[44]);
							if (!nextLine[45].isEmpty()) {
								billingdata.setTerm(Double.parseDouble(nextLine[45]));
							} else {
								billingdata.setTerm(0.0);
							}
							billingdata.setPublishername(nextLine[46]);
							billingdata.setPlanname(nextLine[47]);
							billingdata.setChargetype(nextLine[48]);
							billingdata.setFrequency(nextLine[49]);
							billingdata.setPublishertype(nextLine[50]);
							if (!nextLine[51].isEmpty()) {
								billingdata.setPaygprice(Double.parseDouble(nextLine[51]));
							} else {
								billingdata.setPaygprice(0.0);
							}

							billingdata.setPricingmodel(nextLine[52]);
							billingdata.setCostallocationrulename(nextLine[53]);
							billingdata.setBenefitid(nextLine[54]);
							billingdata.setBenefitname(nextLine[55]);

							batch.add(billingdata);
							batchSize++;
							// 当批次大小达到500时，插入数据库并清空批次
							if (batchSize >= 500) {
								billingDataRepository.saveAll(batch);
								batch.clear();
								batchSize = 0;
							}

						}
						// 插入剩余的数据

						if (!batch.isEmpty()) {

							billingDataRepository.saveAll(batch);
							batch.clear();
						}

					} catch (Exception e) {
						e.printStackTrace();
						// 如果出现错误，可以重定向到错误页面或其他页面
						return "redirect:/error";
					}
				} else if (originalFilename.endsWith(".xlsx")) {
					try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
			            Sheet sheet = workbook.getSheetAt(0); // 假設XLSX文件中只有一個工作表

			            Iterator<Row> rowIterator = sheet.iterator();
			            rowIterator.next(); // 跳過表頭行

			            List<Billingdata> batch = new ArrayList<>();
			            int batchSize = 0;

			            while (rowIterator.hasNext()) {
			                Row row = rowIterator.next();

			                // 在這裡處理 XLSX 行的內容
			                // 創建 Billingdata 物件並設置屬性，這部分需要根據你的 Excel 文件結構來處理
			                Billingdata billingdata = new Billingdata();
			                billingdata.setBillingaccountid(row.getCell(0).getStringCellValue());
			                billingdata.setBillingaccountname(row.getCell(1).getStringCellValue());
			                billingdata.setBillingperiodstartdate(row.getCell(2).getStringCellValue());
			                billingdata.setBillingperiodenddate(row.getCell(3).getStringCellValue());
			                billingdata.setBillingprofileid(row.getCell(4).getStringCellValue());
			                billingdata.setBillingprofilename(row.getCell(5).getStringCellValue());
			                billingdata.setAccountownerid(row.getCell(6).getStringCellValue());
			                billingdata.setAccountname(row.getCell(7).getStringCellValue());
			                billingdata.setSubscriptionid(row.getCell(8).getStringCellValue());
			                billingdata.setSubscriptionname(row.getCell(9).getStringCellValue());
			                billingdata.setDate(row.getCell(10).getStringCellValue());
			                billingdata.setProduct(row.getCell(11).getStringCellValue());
			                billingdata.setPartnumber(row.getCell(12).getStringCellValue());
			                billingdata.setMeterid(row.getCell(13).getStringCellValue());
			                billingdata.setServicefamily(row.getCell(14).getStringCellValue());
			                billingdata.setMetercategory(row.getCell(15).getStringCellValue());
			                billingdata.setMetersubcategory(row.getCell(16).getStringCellValue());
			                billingdata.setMeterregion(row.getCell(17).getStringCellValue());
			                billingdata.setMetername(row.getCell(18).getStringCellValue());
//			                
			                billingdata.setQuantity(row.getCell(19) != null && row.getCell(19).getCellType() == CellType.NUMERIC ?row.getCell(19).getNumericCellValue() : 0.0);
			                billingdata.setEffectiveprice(row.getCell(20) != null && row.getCell(20).getCellType() == CellType.NUMERIC ?row.getCell(20).getNumericCellValue() : 0.0);
			                billingdata.setCost(row.getCell(21) != null && row.getCell(21).getCellType() == CellType.NUMERIC ?row.getCell(21).getNumericCellValue() : 0.0);
			                billingdata.setUnitprice(row.getCell(22) != null && row.getCell(22).getCellType() == CellType.NUMERIC ?row.getCell(22).getNumericCellValue() : 0.0);
			                billingdata.setAllcost(row.getCell(23) != null && row.getCell(23).getCellType() == CellType.NUMERIC ?row.getCell(23).getNumericCellValue() : 0.0);

//			                billingdata.setQuantity(row.getCell(19) != null ? row.getCell(19).getNumericCellValue() : 0.0);
//			                billingdata.setEffectiveprice(row.getCell(20) != null ? row.getCell(20).getNumericCellValue() : 0.0);
//			                billingdata.setCost(row.getCell(21) != null ? row.getCell(21).getNumericCellValue() : 0.0);
//			                billingdata.setUnitprice(row.getCell(22) != null ? row.getCell(22).getNumericCellValue() : 0.0);
//			                billingdata.setAllcost(row.getCell(23) != null ? row.getCell(23).getNumericCellValue() : 0.0);
			                billingdata.setBillingcurrency(row.getCell(24).getStringCellValue());
			                billingdata.setResourcelocation(row.getCell(25).getStringCellValue());
			                billingdata.setAvailabilityzone(row.getCell(26).getStringCellValue());
			                billingdata.setConsumedservice(row.getCell(27).getStringCellValue());
			                billingdata.setResourceid(row.getCell(28).getStringCellValue());
			                billingdata.setResourcename(row.getCell(29).getStringCellValue());
			                billingdata.setServiceinfo1(row.getCell(30).getStringCellValue());
			                billingdata.setServiceinfo2(row.getCell(31).getStringCellValue());
			                billingdata.setAdditionalinfo(row.getCell(32).getStringCellValue());
			                billingdata.setTags(row.getCell(33).getStringCellValue());
			                billingdata.setInvoicesectionid(row.getCell(34).getStringCellValue());
			                billingdata.setInvoicesection(row.getCell(35).getStringCellValue());
			                billingdata.setCostcenter(row.getCell(36).getStringCellValue());
			                billingdata.setUnitofmeasure(row.getCell(37).getStringCellValue());
			                billingdata.setResourcegroup(row.getCell(38).getStringCellValue());
			                billingdata.setReservationid(row.getCell(39).getStringCellValue());
			                billingdata.setReservationname(row.getCell(40).getStringCellValue());
			                billingdata.setProductorderid(row.getCell(41).getStringCellValue());
			                billingdata.setProductordername(row.getCell(42).getStringCellValue());
			                billingdata.setOfferid(row.getCell(43).getStringCellValue());
			                billingdata.setIsazurecrediteligible(row.getCell(44).getStringCellValue());
//			                billingdata.setTerm(row.getCell(45) != null ? row.getCell(45).getNumericCellValue() : 0.0);
			                billingdata.setTerm(row.getCell(45) != null && row.getCell(45).getCellType() == CellType.NUMERIC ?row.getCell(45).getNumericCellValue() : 0.0);

			                billingdata.setPublishername(row.getCell(46).getStringCellValue());
			                billingdata.setPlanname(row.getCell(47).getStringCellValue());
			                billingdata.setChargetype(row.getCell(48).getStringCellValue());
			                billingdata.setFrequency(row.getCell(49).getStringCellValue());
			                billingdata.setPublishertype(row.getCell(50).getStringCellValue());
//			                billingdata.setPaygprice(row.getCell(51) != null ? row.getCell(51).getNumericCellValue() : 0.0);
			                billingdata.setPaygprice(row.getCell(51) != null && row.getCell(51).getCellType() == CellType.NUMERIC ?row.getCell(51).getNumericCellValue() : 0.0);

			                billingdata.setPricingmodel(row.getCell(52).getStringCellValue());
			                billingdata.setCostallocationrulename(row.getCell(53).getStringCellValue());
			                billingdata.setBenefitid(row.getCell(54).getStringCellValue());
			                billingdata.setBenefitname(row.getCell(55).getStringCellValue());

			                // 將 Billingdata 物件添加到批次中
			                batch.add(billingdata);
			                batchSize++;

			                // 當批次大小達到500時，插入數據庫並清空批次
			                if (batchSize >= 500) {
			                    billingDataRepository.saveAll(batch);
			                    batch.clear();
			                    batchSize = 0;
			                }
			            }

			            // 插入剩餘的數據
			            if (!batch.isEmpty()) {
			                billingDataRepository.saveAll(batch);
			                batch.clear();
			            }
			        } catch (Exception e) {
			            e.printStackTrace();
			            return "redirect:/error";
			        }
				}
			}
			return "redirect:/success";
		} else {
			return "redirect:/error";
		}
	}

}

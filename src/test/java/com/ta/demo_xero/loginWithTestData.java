package com.ta.demo_xero;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.ta.demo_xero.pages.LoginToXeroPage;
import com.ta.demo_xero.utilities.BrowserUlitiliesForXero.BrowserType;
import com.ta.demo_xero.utilities.TestBaseForXero;

@Listeners(com.ta.demo_xero.ListenerTest.class)

public class loginWithTestData extends TestBaseForXero{

	//@BeforeMethod
	public void setup() {
		oBrowserUlitiliesForXero.setupWebDriver(BrowserType.CHROME);
	}

	//@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	static int count = 0;

	@Test(dataProvider = "loginUserDataDetails")
	public void logingIntoBrowserTWithTestData(String username, String password, String xpath) throws Exception{
		LoginToXeroPage page = new LoginToXeroPage(driver);

		count++;
		loggerExtentTest = reports.startTest("logingIntoBrowserWithTestData_" + count);

		page.loginToWebSite(username, password);

		loggerExtentTest.log(LogStatus.INFO, "Login button clicked");
		//Thread.sleep(2000);
		oBrowserUlitiliesForXero.explicitWaitFunc(driver.findElement(By.xpath(xpath.trim())), 10);
		AssertJUnit.assertEquals(driver.findElement(By.xpath(xpath.trim())).isDisplayed(), true);
		//logger.log(LogStatus.PASS, "Test case is passed");

		// taking screenshot
		TakesScreenshot ts = (TakesScreenshot) driver; //screenshot setup will be done
		File source = ts.getScreenshotAs(OutputType.FILE);//Takes the screenshot and saving it to surce object

		//source which we saved is not physically saved. but it is there in the object
		String sPathOFScreenshot = System.getProperty("user.dir")+"//screenshot/screnshot_"+"logingIntoBrowserWithTestData_"+count+".png";
		File destnation = new File(sPathOFScreenshot);
		FileUtils.copyFile(source, destnation);

		loggerExtentTest.log(LogStatus.INFO, "Test case is passed");
		loggerExtentTest.log(LogStatus.PASS, loggerExtentTest.addScreenCapture(sPathOFScreenshot));
		reports.endTest(loggerExtentTest);

	}

	@DataProvider(name="loginUserDataDetails")
	public Object[][] getDataForLogin() throws Exception{

		return readExcelAndReturnObject(System.getProperty("user.dir")+"/resources/testData/TD_UserNameAndPassword.xls");

	}


	//how to read ExcelFile -- On Reading Excel file you have to convert data to an multiDimensionalObject
	public Object[][] readExcelAndReturnObject(String sFile) throws Exception{

		HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(sFile));
		//td_userpass
		HSSFSheet myExcleSheet = myExcelBook.getSheet("td_userpass");
		HSSFRow row1 = myExcleSheet.getRow(0);
		System.out.println(myExcleSheet.getPhysicalNumberOfRows());//To take total number of Rows
		//System.out.println(row1.getLastCellNum());
		int iCountCol =row1.getLastCellNum();
		int iCountRow = myExcleSheet.getPhysicalNumberOfRows();
		Object[][] excelData= new Object[iCountRow][iCountCol]; //Creating multi dimensional array
		for(int countRow=0;countRow<iCountRow;countRow++) {
			for(int countCol = 0; countCol<iCountCol;countCol++) {

				HSSFRow tempRow=myExcleSheet.getRow(countRow);
				String sTemp;
				try {
				sTemp=tempRow.getCell(countCol).getStringCellValue();
				}catch(Exception a) {
					sTemp=Double.toString(tempRow.getCell(countCol).getNumericCellValue());
				}
				excelData[countRow][countCol] = sTemp;
			}

		}

		return excelData;
	}
}

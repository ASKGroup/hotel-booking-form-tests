package com.equalExports.technical.assement.page_objects;

import com.equalExports.technical.assement.driver.DriverHelp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.equalExports.technical.assement.utils.DateHelper;

import java.util.List;
import java.util.Map;

public class BookingPage extends DriverHelp {

    private DateHelper dateHelper = new DateHelper();
    @FindBy(css = "#firstname")
    private WebElement firstName;

    @FindBy(css = "#lastname")
    private WebElement secondName;

    @FindBy(css = "#totalprice")
    private WebElement totalPrice;

    @FindBy(css = "#depositpaid")
    private WebElement deposit;

    @FindBy(css = "#checkin")
    private WebElement checkIn;

    @FindBy(css = "#checkout")
    private WebElement checkout;

    @FindBy(css = "input[value=' Save ']")
    private WebElement save;

    @FindBy(css = ".row")
    private List<WebElement> rows;

    public static String firstNameRecord;

    public void fillBookingForm(List<Map<String, String>> dataTable) {
        firstNameRecord = dataTable.get(0).get("firstName");
        firstName.sendKeys(firstNameRecord);
        secondName.sendKeys(dataTable.get(0).get("lastName"));
        totalPrice.sendKeys(dataTable.get(0).get("price"));
        new Select(deposit).selectByVisibleText((dataTable.get(0).get("deposit")));
        checkIn.sendKeys(dateHelper.getTodaysDate());
        checkout.sendKeys(dateHelper.getFutureDate(15));
        save.click();
    }

    public String isRecordExists() {
        sleep(5000);
        String recordName = "";
        for (WebElement row : rows) {
            boolean isRecordFoundOnRow = row.getText().contains(firstNameRecord);
            if (isRecordFoundOnRow) {
                recordName = row.getAttribute("id");
                break;
            }
        }
        return recordName;
    }

    public void deleteRecord() {
        String recordId = isRecordExists();
        driver.findElement(By.cssSelector("input[onclick='deleteBooking(" + recordId + ")']")).click();
    }
}

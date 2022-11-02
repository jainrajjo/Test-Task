import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Testfinal extends Methods {

	public static void main(String[] args) throws IOException, InterruptedException {

		senderCreation();
		receiverCreation();
		login();
		senderRegistration();
		logout();
		receiverRegistration();
		getReceiverAccountNumber();
		BillPayment();
		verification();
	}
}

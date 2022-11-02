import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Methods {
	
	public static WebDriver driver =null;

	public static void senderCreation() {

		RestAssured.baseURI = "https://randomuser.me";
		String sender_response = given().log().all().when().get("/api/").then().assertThat().statusCode(200).extract()
				.response().asString();
		System.out.println(sender_response);

		JsonPath sender_js = new JsonPath(sender_response);
		Sender_First_Name = sender_js.getString("results[0].name.first");
		Sender_Last_Name = sender_js.getString("results[0].name.last");
		Sender_Address = sender_js.getString("results[0].location.street.name");
		Sender_City = sender_js.getString("results[0].location.city");
		Sender_State = sender_js.getString("results[0].location.state");
	    Sender_Zip_Code = sender_js.getString("results[0].location.postcode");
		Sender_Phone = sender_js.getString("results[0].phone");
		Sender_SSN = sender_js.getString("results[0].cell");
		Sender_Username = sender_js.getString("results[0].login.username");
		Sender_Password = sender_js.getString("results[0].login.password");
		Sender_Confirm = sender_js.getString("results[0].login.password");

		System.out.println(Sender_First_Name);
		System.out.println(Sender_Last_Name);
		System.out.println(Sender_Address);
		System.out.println(Sender_City);
		System.out.println(Sender_State);
		System.out.println(Sender_Zip_Code);
		System.out.println(Sender_Phone);
		System.out.println(Sender_SSN);
		System.out.println(Sender_Username);
		System.out.println(Sender_Password);
		System.out.println(Sender_Confirm);
	}
	
	public static String Sender_First_Name=null;
	public static String Sender_Last_Name=null;
	public static String Sender_Address=null;
	public static String Sender_City=null;
	public static String Sender_State=null;
	public static String Sender_Zip_Code=null;
	public static String Sender_Phone=null;
	public static String Sender_SSN=null;
	public static String Sender_Username=null;
	public static String Sender_Password=null;
	public static String Sender_Confirm=null;

	public static void receiverCreation() {

		String recipient_response = given().log().all().when().get("/api/").then().assertThat().statusCode(200)
				.extract().response().asString();
		System.out.println(recipient_response);

		JsonPath recipient_js = new JsonPath(recipient_response);
		recipient_First_Name = recipient_js.getString("results[0].name.first");
	    recipient_Last_Name = recipient_js.getString("results[0].name.last");
		 recipient_Address = recipient_js.getString("results[0].location.street.name");
		 recipient_City = recipient_js.getString("results[0].location.city");
		 recipient_State = recipient_js.getString("results[0].location.state");
		 recipient_Zip_Code = recipient_js.getString("results[0].location.postcode");
		 recipient_Phone = recipient_js.getString("results[0].phone");
		 recipient_SSN = recipient_js.getString("results[0].cell");
		 recipient_Username = recipient_js.getString("results[0].login.username");
		 recipient_Password = recipient_js.getString("results[0].login.password");
		 recipient_Confirm = recipient_js.getString("results[0].login.password");

		System.out.println(recipient_First_Name);
		System.out.println(recipient_Last_Name);
		System.out.println(recipient_Address);
		System.out.println(recipient_City);
		System.out.println(recipient_State);
		System.out.println(recipient_Zip_Code);
		System.out.println(recipient_Phone);
		System.out.println(recipient_SSN);
		System.out.println(recipient_Username);
		System.out.println(recipient_Password);
		System.out.println(recipient_Confirm);
	}
	public static String recipient_First_Name=null;
	public static String recipient_Last_Name=null;
	public static String recipient_Address=null;
	public static String recipient_City=null;
	public static String recipient_State=null;
	public static String recipient_Zip_Code=null;
	public static String recipient_Phone=null;
	public static String recipient_SSN=null;
	public static String recipient_Username=null;
	public static String recipient_Password=null;
	public static String recipient_Confirm=null;
	

	public static void login() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/register.htm");

	}

	public static void senderRegistration() {
		//Methods method=new Methods();

		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys(Sender_First_Name);
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys(Sender_Last_Name);
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys(Sender_Address);
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys(Sender_City);
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys(Sender_State);
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys(Sender_Zip_Code);
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys(Sender_Phone);
		driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys(Sender_SSN);
		driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys(Sender_Username);
		driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys(Sender_Password);
		driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys(Sender_Confirm);
		driver.findElement(By.xpath("//input[@value='Register']")).click();
	}

	public static void logout() {
		driver.findElement(By.xpath("//a[normalize-space()='Log Out']")).click();

	}

	public static void receiverRegistration() {

		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys(recipient_First_Name);
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys(recipient_Last_Name);
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys(recipient_Address);
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys(recipient_City);
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys(recipient_State);
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys(recipient_Zip_Code);
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys(recipient_Phone);
		driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys(recipient_SSN);
		driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys(recipient_Username);
		driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys(recipient_Password);
		driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys(recipient_Confirm);
		driver.findElement(By.xpath("//input[@value='Register']")).click();
	}

	public static void getReceiverAccountNumber() throws InterruptedException {
		driver.findElement(By.xpath("//a[normalize-space()='Accounts Overview']")).click();
		Thread.sleep(1000);
		recipient_account_number = driver.findElement(By.xpath("//a[@class='ng-binding']")).getText();
		driver.findElement(By.xpath("//a[normalize-space()='Log Out']")).click();
	}
	public static String recipient_account_number=null;

	public static void BillPayment() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Sender_Username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Sender_Password);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Bill Pay']")).click();

		driver.findElement(By.xpath("//input[@name='payee.name']")).sendKeys(recipient_First_Name);
		driver.findElement(By.xpath("//input[@name='payee.address.street']")).sendKeys(recipient_Address);
		driver.findElement(By.xpath("//input[@name='payee.address.city']")).sendKeys(recipient_City);
		driver.findElement(By.xpath("//input[@name='payee.address.state']")).sendKeys(recipient_State);
		driver.findElement(By.xpath("//input[@name='payee.address.zipCode']")).sendKeys(recipient_Zip_Code);
		driver.findElement(By.xpath("//input[@name='payee.phoneNumber']")).sendKeys(recipient_Phone);
		driver.findElement(By.xpath("//input[@name='payee.accountNumber']")).sendKeys(recipient_account_number);
		driver.findElement(By.xpath("//input[@name='verifyAccount']")).sendKeys(recipient_account_number);
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("100");
		driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
	}

	public static void verification() throws InterruptedException {
		Thread.sleep(2000);
		String confirm_message = driver.findElement(By.xpath("(//h1[normalize-space()='Bill Payment Complete'])[1]"))
				.getText();
		System.out.println(confirm_message);
		Assert.assertEquals(confirm_message, "Bill Payment Complete");
	}
}

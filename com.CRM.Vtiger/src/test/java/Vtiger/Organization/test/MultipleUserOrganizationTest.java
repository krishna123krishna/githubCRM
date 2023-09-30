package Vtiger.Organization.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.CRM.Vtiger.GenericUtilities.BaseClass;
import com.CRM.Vtiger.GenericUtilities.ExcelFileutility;
import com.CRM.Vtiger.GenericUtilities.Javautilty;
import com.CRM.Vtiger.ObjectRepository.CreateNewOrganizationPage;
import com.CRM.Vtiger.ObjectRepository.HomePage;
import com.CRM.Vtiger.ObjectRepository.OrganizationInfoPage;
import com.CRM.Vtiger.ObjectRepository.OrganizationPage;

public class MultipleUserOrganizationTest extends BaseClass{

	@Test(dataProvider ="multipleData",dataProviderClass = ExcelFileutility.class)
	public void verifyUserCreateOrganizationTest(String mulorgname) throws Throwable {
		
		//ExcelFileutility eutil=new ExcelFileutility();
		Javautilty jutil=new Javautilty();
		//String orgname=e.dataFromExcelUtility("Sheet1", 2,0)+j.randomNumber();
		String orgname=mulorgname+jutil.getrandom();
		HomePage h=new HomePage(driver);
		h.clickOrganization();
		OrganizationPage o=new OrganizationPage(driver);
		o.clickOrgLookUpImg();
		CreateNewOrganizationPage c=new CreateNewOrganizationPage(driver);
		c.createName(orgname);
		OrganizationInfoPage or=new OrganizationInfoPage(driver);
		String s=or.orgHader();
		Assert.assertTrue(s.contains(orgname));
		System.out.println("pass");
	}

}

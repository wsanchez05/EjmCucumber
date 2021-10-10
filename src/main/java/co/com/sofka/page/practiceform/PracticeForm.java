package co.com.sofka.page.practiceform;


import co.com.sofka.model.praticeForm.PracticeFormModel;
import co.com.sofka.page.common.CommonActionOnPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class PracticeForm extends CommonActionOnPages {

    private final PracticeFormModel practiceFormModel;
    private final By name = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By genderMale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label");
    private final By genderFemale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label");
    private final By genderOther = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[3]");
    private final By mobile = By.id("userNumber");
    private final By submit = By.id("submit");

    private final By studentNameAssertion =By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]");
    private final By genderAssertion =By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]");
    private final By mobileAssertion =By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]");

    public PracticeForm(WebDriver driver, PracticeFormModel practiceFormModel ) {

        super(driver);
        this.practiceFormModel = practiceFormModel;
    }
// Funcion para llenar los campos obligatorios del formulario
    public void fillStudentForm(){

        clear(name);
        type(name,practiceFormModel.getName());

        clear(lastName);
        type(lastName,practiceFormModel.getLastName());

        switch (practiceFormModel.getGender()){

            case FEMALE:
                clickOn(genderFemale);
                break;
            case MALE:
                clickOn(genderMale);
                break;
            case OTHER:
                clickOn(genderOther);
                break;
            default:
        }

        clear(mobile);
        type(mobile,practiceFormModel.getMobile());

        doSubmit(submit);
    }







    public List<String> IsRegistrationDone() {
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add(getText(studentNameAssertion).trim());
        submitedFormResult.add(getText(genderAssertion).trim());
        submitedFormResult.add(getText(mobileAssertion).trim());
        return submitedFormResult;
    }

}

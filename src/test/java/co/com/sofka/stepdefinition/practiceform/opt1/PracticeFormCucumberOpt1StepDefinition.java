package co.com.sofka.stepdefinition.practiceform.opt1;

import co.com.sofka.model.praticeForm.PracticeFormModel;
import co.com.sofka.page.practiceform.PracticeForm;
import co.com.sofka.stepdefinition.setup.WebUI;
import co.com.sofka.util.Gender;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormCucumberOpt1StepDefinition extends WebUI {

    private PracticeFormModel practiceFormModel;
    private PracticeForm practiceForm;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";

    @Given("que el empleado administrativo se encuentre en la pagina web de los ingresos de estudiantes")
    public void queElEmpleadoAdministrativoSeEncuentreEnLaPaginaWebDeLosIngresosDeEstudiantes() {
        try{
            generalSetUp();
            practiceFormModel = new PracticeFormModel();
            practiceFormModel.setName("William");
            practiceFormModel.setLastName("Sanchez");
            practiceFormModel.setGender(Gender.MALE);
            practiceFormModel.setMobile("3107684014");
        }catch(Exception exception){
            quitDriver();
        }
    }

    @When("el empleado administrativo ingresa los campos obligatorios y confirma la accion")
    public void elEmpleadoAdministrativoIngresaLosCamposObligatoriosYConfirmaLaAccion() {
        try {
            practiceForm = new PracticeForm(driver,practiceFormModel);
            practiceForm.fillStudentForm();
        }catch (Exception exception){
            quitDriver();
        }
    }

    @Then("el sistema debera mostrar por pantalla el registro del estudiante ingresado.")
    public void elSistemaDeberaMostrarPorPantallaElRegistroDelEstudianteIngresado() {
        try {

            Assertions.assertEquals(practiceForm.IsRegistrationDone(),
                    forSubmittedForm(), ASSERTION_EXCEPTION_MESSAGE);

        }catch (Exception exception){
            quitDriver();
        }
        finally {
            quitDriver();
        }
    }
    private List<String> forSubmittedForm(){
        List<String> submitedFormResult = new ArrayList<String>();
        submitedFormResult.add(practiceFormModel.getName() + " " + practiceFormModel.getLastName());
        submitedFormResult.add(practiceFormModel.getGender().getValue());
        submitedFormResult.add(practiceFormModel.getMobile());
        return submitedFormResult;
    }

}

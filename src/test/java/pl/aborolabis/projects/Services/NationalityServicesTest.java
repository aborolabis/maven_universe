package pl.aborolabis.projects.Services;

import org.junit.jupiter.api.Test;
import pl.aborolabis.projects.EntityObjects.Nationality;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NationalityServicesTest {

    private NationalityServices nationalityServices = new NationalityServices();

    @Test
    void findAllNations() {
        List<Nationality> listOfNations = nationalityServices.findAllNations();

        listOfNations.stream().forEach(nationality -> System.out.println(nationality.toString()));
    }

    @Test
    void createANationality(){
        int asgard = nationalityServices.createANationalityWithNameOnly("Asgard");

        System.out.println(asgard);
    }

    @Test
    void findNationByHisId(){
        Nationality nationByHisId = nationalityServices.findNationByHisId(5);

        System.out.println(nationByHisId.toString());
    }

    @Test
    void findNationByHisName(){
        String name = "asgard";
        Nationality nation = nationalityServices.findNationByHisName(name);

        System.out.println(nation.toString());
    }

    @Test
    void deleteNation(){
        int id = 5;

        nationalityServices.delete(5);

        List<Nationality> allNations = nationalityServices.findAllNations();
        allNations.stream().forEach(nationality -> System.out.println(nationality.toString()));
    }
}
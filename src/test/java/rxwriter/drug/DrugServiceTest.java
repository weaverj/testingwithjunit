package rxwriter.drug;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DrugServiceTest {

    @Test
    void drugsAreReturnedSorted() {
        DrugService service = new DrugService();
        List<DispensableDrug> foundDrugs = service.findDrugsStartingWith("as");
        assertNotNull(foundDrugs);
        assertEquals(2, foundDrugs.size());
        assertEquals("asmanex", foundDrugs.get(0).drugName());
        assertEquals("aspirin", foundDrugs.get(1).drugName());
    }

    @Test
    void throwsExceptionOnEmptyStartsWith() {
        DrugService service = new DrugService();
        Exception thrown = assertThrows(IllegalArgumentException.class,
                ()-> service.findDrugsStartingWith("  "));
        System.out.println(thrown.getMessage());
    }

    @Test
    void setsDrugPropertiesCorrectly() {
        DrugService service = new DrugService();
        List<DispensableDrug> foundDrugs = service.findDrugsStartingWith("aspirin");
        DrugClassification[] expectedClassifications = new DrugClassification[] {
                DrugClassification.ANALGESIC, DrugClassification.PLATELET_AGGREGATION_INHIBITORS
        };
        DispensableDrug drug = foundDrugs.get(0);
        assertAll("DispensableDrug properties",
                () -> assertEquals("aspirin", drug.drugName()),
                () -> assertFalse(drug.isControlled()),
                () -> assertEquals(2, drug.drugClassifications().length),
                () -> assertArrayEquals(expectedClassifications, drug.drugClassifications())
        );
    }

}
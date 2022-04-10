package rxwriter.prescription;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DurationParserTest {

    @Test
    public void parseDurationWithValidUnitAndQuantity() {
        assertEquals(14, DurationParser.parseDays("2 weeks"));
        assertEquals(30, DurationParser.parseDays("1 month"));
    }

}
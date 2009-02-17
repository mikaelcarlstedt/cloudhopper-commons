
package net.cloudhopper.commons.locale;

// java imports
import java.io.IOException;

// third party imports
import java.util.List;
import org.junit.*;
import org.apache.log4j.Logger;

// my imports

/**
 *
 * @author joelauer
 */
public class CountryUtilTest {

    private static final Logger logger = Logger.getLogger(CountryUtilTest.class);


    @Test(expected=IOException.class)
    public void parse() throws Exception {
        Country c = Country.parse("");
    }

    @Test(expected=IOException.class)
    public void parse2() throws Exception {
        Country c = Country.parse("dffsdfasdf");
    }

    @Test(expected=IOException.class)
    public void parse3() throws Exception {
        Country c = Country.parse("AA AAA 123");
    }

    @Test(expected=IOException.class)
    public void parse4() throws Exception {
        Country c = Country.parse("AA AAA 123 ");
    }

    @Test(expected=IOException.class)
    public void parse5() throws Exception {
        Country c = Country.parse(null);
    }

    @Test
    public void parseOK() throws Exception {
        Country c = Country.parse("AA AAA 123 J");
    }

    @Test
    public void countryByName() throws Exception {
        List<Country> countries = CountryUtil.getCountriesByName();
        // first couple element check, name isn't in Country's comparison
        /**
         * AF AFG 004 Afghanistan
AL ALB 008 Albania, People's Socialist Republic of
DZ DZA 012 Algeria, People's Democratic Republic of
AS ASM 016 American Samoa
AD AND 020 Andorra, Principality of
         */
        Assert.assertEquals(countries.get(0), new Country("AF", ""));
        Assert.assertEquals(countries.get(1), new Country("AL", ""));
        Assert.assertEquals(countries.get(2), new Country("DZ", ""));
        Assert.assertEquals(countries.get(3), new Country("AS", ""));
        Assert.assertEquals(countries.get(4), new Country("AD", ""));
    }

    
}

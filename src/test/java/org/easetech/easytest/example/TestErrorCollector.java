package org.easetech.easytest.example;

import javax.inject.Inject;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Intercept;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.annotation.TestConfigProvider;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "classpath:org/easetech/data/testExcelData.xls" })
@TestConfigProvider({TestConfigProviderClass.class})
public class TestErrorCollector {
    
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Intercept
    @Inject
    private ItemService itemService;
    
    @Test
    public void getExcelTestData(@Param(name="libraryId")
    Float libraryId, @Param(name="itemId")
    Float itemId) {
        collector.addError(new Throwable("first thing went wrong"));
        collector.addError(new Throwable("second thing went wrong"));
        System.out.println("Executing getExcelTestData :");
        
    }
    
    @Test
    public void testSimpleTest() {
        collector.addError(new Throwable("third thing went wrong"));
        collector.addError(new Throwable("fourth thing went wrong"));
        System.out.println("Executing getExcelTestData :");
    }

}

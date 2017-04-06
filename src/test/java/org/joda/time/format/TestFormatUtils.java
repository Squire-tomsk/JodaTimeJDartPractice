package org.joda.time.format;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;

import java.io.IOException;

/**
 * Created by abuca on 05.04.17.
 */
public class TestFormatUtils extends TestCase {
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestFormatUtils.class);
    }

    public TestFormatUtils(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    // Abugaliev A.A. new test mutant 144 1. negated conditional → SURVIVED
    //

    public void test_AppendPaddedInteger() {
        StringBuilder sb = new StringBuilder();
        try {
            FormatUtils.appendPaddedInteger(sb,72057594037927936L,5);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(sb.toString(),"72057594037927936");
    }

    //-----------------------------------------------------------------------
    // Abugaliev A.A. new test mutant 149 2. negated conditional → SURVIVED
    //

    public void test_AppendPaddedInteger2() {
        StringBuilder sb = new StringBuilder();
        try {
            FormatUtils.appendPaddedInteger(sb,72057594037927936L,20);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(sb.toString(),"00072057594037927936");
    }

    //-----------------------------------------------------------------------
    // Abugaliev A.A. new test mutant 151 1. negated conditional → SURVIVED
    //

    public void test_AppendPaddedInteger3() {
        StringBuilder sb = new StringBuilder();
        try {
            FormatUtils.appendPaddedInteger(sb,-72057594037927936L,20);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(sb.toString(),"-00072057594037927936");
    }



    //-----------------------------------------------------------------------
    // test created: Mazaeva E.
    //mutant 414 9. replaced return of integer sized value with (x == 0 ? 1 : 0) -> KILLED
    public void test_CalculateDigitCount1() {
        int result = FormatUtils.calculateDigitCount(0l);
        Assert.assertEquals(1, result);
    }

    // test created: Mazaeva E.
    //mutant 414 6. negated conditional -> KILLED
    public void test_CalculateDigitCount2() {
	int result = FormatUtils.calculateDigitCount(32l);
	Assert.assertEquals(2, result);
    }

    // test created: Mazaeva E.
    //mutant 414 7. negated conditional -> KILLED
    public void test_CalculateDigitCount3() {
	int result = FormatUtils.calculateDigitCount(512l);
        Assert.assertEquals(3, result);
    }

    // test created: Mazaeva E.
    //mutant 411 1. replaced return of integer sized value with (x == 0 ? 1 : 0) → KILLED
    public void test_CalculateDigitCount4() {
        int result = FormatUtils.calculateDigitCount(-9223372036854775808l);
        Assert.assertEquals(20, result);
    }

    // test created: Mazaeva E.
    //mutants 409 2. Replaced integer addition with subtraction → KILLED; 3. replaced return of integer sized value with (x == 0 ? 1 : 0) → KILLED
    public void test_CalculateDigitCount5() {
	int result = FormatUtils.calculateDigitCount(-33l);
        Assert.assertEquals(3, result);
    }

// test created: Mazaeva E.
    //mutants 414 8. negated conditional → KILLED;
    // 419 1. Replaced double division with multiplication → KILLED; 2. Replaced integer addition with subtraction → KILLED
    public void test_CalculateDigitCount() {
        int result = FormatUtils.calculateDigitCount(-4611686018427387904l);
        Assert.assertEquals(20, result);
    }

    // test created: Mazaeva E.
    //mutants 436 1. changed conditional boundary → KILLED, 2. negated conditional → KILLED
    //437 1. mutated return of Object value for org/joda/time/format/FormatUtils::createErrorMessage to ( if (x != null) null else throw new RuntimeException ) → KILLED
    public void test_CreateErrorMessage1() {
	String result = FormatUtils.createErrorMessage("", 0);
	Assert.assertEquals(result, "Invalid format: \"\"");
    }

    // test created: Mazaeva E.
    //mutants 440 2. negated conditional → KILLED
    //441 1. mutated return of Object value for org/joda/time/format/FormatUtils::createErrorMessage to ( if (x != null) null else throw new RuntimeException ) → KILLED
    public void test_CreateErrorMessage2() {
	String result = FormatUtils.createErrorMessage("", 1);
	Assert.assertEquals(result, "Invalid format: \"\" is too short");
    }

    // test created: Mazaeva E.
    //mutants 430 1. changed conditional boundary → KILLED; 2. Replaced integer addition with subtraction → KILLED
    public void test_CreateErrorMessage3() {
	String result = FormatUtils.createErrorMessage("aaa", -32);
	Assert.assertEquals(result, "Invalid format: \"aaa\"");
    }

    //test created: Mazaeva E.
    //mutant 444 1. mutated return of Object value for org/joda/time/format/FormatUtils::createErrorMessage to ( if (x != null) null else throw new RuntimeException ) → KILLED
    public void test_CreateErrorMessage4() {
	String result = FormatUtils.createErrorMessage("aa", 1);
	Assert.assertEquals(result, "Invalid format: \"aa\" is malformed at \"" +
	"aa".substring(1) + '"');
    }
	//test created: Mazaeva E.
     	//mutant 440 1. KILLED
	public void test_createErrorMessage5() {
		String result = FormatUtils.createErrorMessage("string",6);
		Assert.assertEquals(result, "Invalid format: \"string\" is too short");
	}

	//created by Alexey Trusov
	//mutant 145 killed
	public void test_appendPaddedInteger1() {
		StringBuilder sb = new StringBuilder();
		try {
		    FormatUtils.appendPaddedInteger(sb,0L,1);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Assert.assertEquals(sb.toString(),"0");
	}
	
	//created by Alexey Trusov
	//mutants 154 1, 2, 3 killed
	public void test_appendPaddedInteger2() {
		StringBuilder sb = new StringBuilder();
		try {
		    FormatUtils.appendPaddedInteger(sb,-9223372036854775808l,42);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Assert.assertEquals(sb.toString(),"-000000000000000000000009223372036854775808");
	}
	
	//created by Alexey Trusov
	//mutant 302 killed
	public void test_appendUnpaddedInteger2() {
		StringBuilder sb = new StringBuilder();
		try {
		    FormatUtils.appendUnpaddedInteger(sb,100);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Assert.assertEquals(sb.toString(),"100");
	}

	//created by Alexey Trusov
	//mutant 74 1. memory error
	public void test_appendPaddedInteger5() {
		StringBuilder sb = new StringBuilder();
		try {
		    FormatUtils.appendPaddedInteger(sb, Integer.MIN_VALUE, 11);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Assert.assertEquals(sb.toString(), "-02147483648");
	}

	//created by Alexey Trusov
	//mutant 74 2. killed, 3. killed1.
	public void test_appendPaddedInteger6() {
		StringBuilder sb = new StringBuilder();
		try {
		    FormatUtils.appendPaddedInteger(sb, Integer.MIN_VALUE, 10);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Assert.assertEquals(sb.toString(), "-2147483648");
	}


	//created by Alexey Trusov
	//mutant 86 1. killed
	public void test_appendPaddedInteger7() {
		StringBuilder sb = new StringBuilder();
		try {
		    FormatUtils.appendPaddedInteger(sb, 100, 2);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Assert.assertEquals(sb.toString(), "100");
	}
	

	//created by Alexey Trusov
	//mutant 414 4 killed
	public void test_calculateDigitCount10() {
		int result = FormatUtils.calculateDigitCount(10);
		Assert.assertEquals(result, 2);
	}



	//created by Alexey Trusov
	//mutant 414 3 killed
	public void test_calculateDigitCount11() {
		int result = FormatUtils.calculateDigitCount(100);
		Assert.assertEquals(result, 3);
	}

	//created by Alexey Trusov
	//mutant 414 2 killed
	public void test_calculateDigitCount12() {
		int result = FormatUtils.calculateDigitCount(1000);
		Assert.assertEquals(result, 4);
	}

	//created by Alexey Trusov
	//mutant 414 1 killed
	public void test_calculateDigitCount13() {
		int result = FormatUtils.calculateDigitCount(10000);
		Assert.assertEquals(result, 5);
	}
}

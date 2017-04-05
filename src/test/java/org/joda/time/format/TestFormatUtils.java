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
}

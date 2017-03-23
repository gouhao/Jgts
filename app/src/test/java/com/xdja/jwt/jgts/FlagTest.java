package com.xdja.jwt.jgts;

import com.xdja.jwt.jgts.common.Flag;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gouhao on 3/21/2017.
 */

public class FlagTest {
    private Flag flag;

    private static final int INDEX_TEST1 = 0;
    private static final int INDEX_TEST2 = 2;

    @Before
    public void setup(){
        flag = new Flag();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void testFlag1(){
        flag.set(true, INDEX_TEST1);
        assert flag.get(INDEX_TEST1) == true;

        flag.set(false, INDEX_TEST1);
        assert flag.get(INDEX_TEST1) == false;
    }

    @Test
    public void testFlag2(){
        flag.set(true, INDEX_TEST2);
        assert flag.get(INDEX_TEST2) == true;

        flag.set(false, INDEX_TEST2);
        assert flag.get(INDEX_TEST2) == false;
    }

    @Test
    public void testFlag3(){
        flag.set(true, INDEX_TEST1);
        flag.set(true, INDEX_TEST2);

        assert flag.get(INDEX_TEST1) == true;
        assert flag.get(INDEX_TEST2) == true;

        flag.set(false, INDEX_TEST1);
        flag.set(false, INDEX_TEST2);
        assert flag.get(INDEX_TEST1) == false;
        assert flag.get(INDEX_TEST2) == false;

        flag.set(true, INDEX_TEST1);
        flag.set(false, INDEX_TEST2);
        assert flag.get(INDEX_TEST1) == true;
        assert flag.get(INDEX_TEST2) == false;

        flag.set(false, INDEX_TEST1);
        flag.set(true, INDEX_TEST2);
        assert flag.get(INDEX_TEST1) == false;
        assert flag.get(INDEX_TEST2);
    }
}

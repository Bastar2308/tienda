/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

/**
 *
 * @author Profesor Bastar
 */
public class TestA {
    
    private TestA() {
    }
    
    public static TestA getInstance() {
        return TestAHolder.INSTANCE;
    }
    
    private static class TestAHolder {

        private static final TestA INSTANCE = new TestA();
    }
    
}

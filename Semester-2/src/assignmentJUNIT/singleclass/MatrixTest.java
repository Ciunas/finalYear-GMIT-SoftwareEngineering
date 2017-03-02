package assignmentJUNIT.singleclass;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MatrixTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void arrayTest2D() {
		
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix D = new Matrix(d);
		
		assertEquals("Doubles are equal", d[0][0], D.getData(0 ,0), 0.01); // fourth value is the amount of decimal places that it asserts to.
	}
	
//	@Test
//	public void printTest() {
//		
//		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
//		Matrix D = new Matrix(d);
//	    assertEquals("1", D.getData(0 ,0));
//	}
	
	
	@Test
	public void equals() {
		
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix D = new Matrix(d);
		Matrix A = D;
		
	    assertTrue(A.eq(D));
	}
	
	@Test
	public void testTranspose() {
		
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix D = new Matrix(d);
		Matrix A = D.transpose();
	    assertFalse(A.eq(D));
	}
	
	
	
	@Test
	public void illegalPlusError() throws Exception {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Illegal matrix dimensions.");
		Matrix A = Matrix.random(5, 5);
		Matrix C = Matrix.random(7, 7);
		Matrix E = A.plus(C);

	}

	@Test
	public void testPlusMethod() throws Exception {
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		double[][] d1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix A = new Matrix(d); 
		Matrix B = new Matrix(d); 
		Matrix D = A.plus(B);   
		assertTrue( D.getData(0, 0) == 2);   
    }
	
	
	@Test
    public void illegalMiusError()  throws Exception{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Illegal matrix dimensions.");   
		Matrix A = Matrix.random(5, 5);
		Matrix C = Matrix.random(7, 7);
		Matrix E = A.minus(C);       
         
    }
	
	
	@Test
    public void testMinusMethod()  throws Exception{
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		double[][] d1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix A = new Matrix(d); 
		Matrix B = new Matrix(d); 
		Matrix C = A.minus(B);   
		assertEquals(C.getData(0, 0), 0, 0);  
    }
	
	@Test
    public void illegalMultiplicationError()  throws Exception{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Illegal matrix dimensions.");   
		Matrix A = Matrix.random(5, 5);
		Matrix C = Matrix.random(7, 7);
		Matrix E = A.times(C);               
    }
	
	@Test
    public void testlMultiplication()  throws Exception{
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		double[][] d1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix A = new Matrix(d); 
		Matrix B = new Matrix(d); 
		Matrix C = A.times(B);
		assertEquals(C.getData(0, 0), 1, 0);               
    }
	
	
	
	@Test
    public void testEqError()  throws Exception{
		thrown.expect(RuntimeException.class);
		Matrix A = Matrix.random(5, 5);
		Matrix C = Matrix.random(7, 7);
		A.eq(C);       
        thrown.expectMessage("Illegal matrix dimensions.");   
        
    }
	
	@Test
    public void testSwapMethod()  throws Exception{
		
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix D = new Matrix(d); 
		D.swap(1 ,2);
		assertTrue( D.getData(1, 0) == 9); 
    }
	
	@Test
    public void checkingElementMTest()  throws Exception{
		
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix D = new Matrix(d);
		assertEquals(3, D.getM());
    }
	
	@Test
    public void checkingElementNTest()  throws Exception{
		
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix D = new Matrix(d);
		assertEquals(3, D.getN());
    }
    
    @Test
    public void copyTest()  throws Exception{
		
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix D = new Matrix(d);
		Matrix A = new Matrix(D);
		assertTrue(A.eq(D));
    }
    
    @Test
    public void identityMatrixTest1()  throws Exception{
    	
    	boolean test = false;
		Matrix A = Matrix.identity(6);
		
		for (int i = 0; i < 6; i++){
			if( A.getData(i, i) == 1)
				test = true;
				
		}
		assertTrue(test);
    }
    
    @Test
    public void identityMatrixTest2()  throws Exception{
    	
    	boolean test = true;
		Matrix A = Matrix.identity(6);
		
		for (int i = 0; i < 6; i++){
			if( A.getData(i, i) == 1)
				test = false;
		}
		assertFalse(test);
    }
    
    @Test
    public void testShow()  throws Exception{
    	double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix D = new Matrix(d);
    	//D.show();
    	assertTrue(true);
    }
    
    
	
	@Test
    public void testSolveRuntimeError()  throws Exception{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Illegal matrix dimensions.");
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		double[][] d1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix A = new Matrix(d); 
		Matrix B = new Matrix(d); 
		A.solve(B);  
        
    }
	
	@Test
    public void testSolveRuntimeErrorSingular()  throws Exception{
		thrown.expect(RuntimeException.class);
        thrown.expectMessage("Matrix is singular.");   
		double[][] d = { { 0 } };
		double[][] d1 = { { 0 }};
		Matrix A = new Matrix(d); 
		Matrix B = new Matrix(d1); 
		A.solve(B);            
    }
	
	
    @Test
    public void testSolve()  throws Exception{
    	
		Matrix A = Matrix.random(5, 5);
		
		Matrix B = Matrix.random(5, 1);
		A.solve(B);
		A.show();
		assertEquals(A.getData(0, 0), 1, 0);
    }


}

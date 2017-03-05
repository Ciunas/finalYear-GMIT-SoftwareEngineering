package assignmentJUNIT.singleclass.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import assignmentJUNIT.singleclass.Matrix;

public class MatrixTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	
	/*
	 * Test that two elements are equal in matrix that has been coppied
	 */
	@Test
	public void arrayTest2D() {
		
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix D = new Matrix(d);
		
		assertEquals("Doubles are equal", d[0][0], D.getData(0 ,0), 0.01); // fourth value is the amount of decimal places that it asserts to.
	}
	

	
	/*
	 * Test that the two matrixes are the same
	 */
	@Test
	public void equals() {
		
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix D = new Matrix(d);
		Matrix A = D;
		
	    assertTrue(A.eq(D));
	}
	
	
	/*
	 * Test the transpostion of a matrix reutrns the correct answere
	 */
	@Test
	public void testTranspose() {
		
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix D = new Matrix(d);
		Matrix A = D.transpose();
	    assertFalse(A.eq(D));
	}
	
	/*
	 * Testing for an exception being thrown. RUntime exception. Exception thrown inhte plus method when two matrices are differnet size
	 */
	@Test
	public void illegalPlusError() throws Exception {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Illegal matrix dimensions.");
		Matrix A = Matrix.random(5, 5);
		Matrix C = Matrix.random(7, 7);
		Matrix E = A.plus(C);

	}

	/*
	 * Testing that the addition of two matrices return the correct answer
	 */
	@Test
	public void testPlusMethod() throws Exception {
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		double[][] d1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix A = new Matrix(d); 
		Matrix B = new Matrix(d); 
		Matrix D = A.plus(B);   
		assertTrue( D.getData(0, 0) == 2);   
    }
	
	
	/*
	 * Testing for an exception being thrown. RUntime exception. Exception thrown in the minus method when two matrices are different size
	 */
	@Test
    public void illegalMiusError()  throws Exception{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Illegal matrix dimensions.");   
		Matrix A = Matrix.random(5, 5);
		Matrix C = Matrix.random(7, 7);
		Matrix E = A.minus(C);       
         
    }
	
	
	/*
	 * Testing the minus method, asserting theat the correct answere is returned when two matrices are subtracted.
	 */
	@Test
    public void testMinusMethod()  throws Exception{
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		double[][] d1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix A = new Matrix(d); 
		Matrix B = new Matrix(d); 
		Matrix C = A.minus(B);   
		assertEquals(C.getData(0, 0), 0, 0);  
    }
	
	/*
	 * Testing for an exception being thrown. RUntime exception. Excetpiotn thrown wehn trying to multiple two matrices. If the aren't multiplyable
	 */
	@Test
    public void illegalMultiplicationError()  throws Exception{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Illegal matrix dimensions.");   
		Matrix A = Matrix.random(5, 5);
		Matrix C = Matrix.random(7, 7);
		Matrix E = A.times(C);               
    }
	
	/*
	 * Testing hthat the answerer from a matrix multiplication method returns the correct answer.
	 */
	@Test
    public void testlMultiplication()  throws Exception{
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		double[][] d1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix A = new Matrix(d); 
		Matrix B = new Matrix(d); 
		Matrix C = A.times(B);
		assertEquals(C.getData(0, 0), 1, 0);               
    }
	
	
	
	/*
	 * Testing two different Matrices are the same. Runtime exception of they are differnet sizes
	 */
	@Test
    public void testEqError()  throws Exception{
		thrown.expect(RuntimeException.class);
		Matrix A = Matrix.random(5, 5);
		Matrix C = Matrix.random(7, 7);
		A.eq(C);       
        thrown.expectMessage("Illegal matrix dimensions.");   
        
    }
	
	
	/*
	 * Testing a swap method, swaps the rows of the amtrix.
	 */
	@Test
    public void testSwapMethod()  throws Exception{
		
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix D = new Matrix(d); 
		D.swap(1 ,2);
		assertTrue( D.getData(1, 0) == 9); 
    }
	
	/*
	 * Testing the getter is working row count of a Matrix
	 */
	@Test
    public void checkingElementMTest()  throws Exception{
		
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix D = new Matrix(d);
		assertEquals(3, D.getM());
    }
	
	

	/*
	 * Testing the getter is working column count of a Matrix
	 */
	@Test
    public void checkingElementNTest()  throws Exception{
		
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix D = new Matrix(d);
		assertEquals(3, D.getN());
    }
    
	

	/*
	 * Testing the copy function of the Matrix. Both matrixes should be the same.
	 */
    @Test
    public void copyTest()  throws Exception{
		
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix D = new Matrix(d);
		Matrix A = new Matrix(D);
		assertTrue(A.eq(D));
    }
    

	/*
	 * Testing for the Identity Matrix
	 */
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
    
    

	/*
	 * Testing that error  in the identity Matrix method
	 */
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
    
    

	/*
	 * Testing teh show method, this prints a Matirx
	 */
    @Test
    public void testShow()  throws Exception{
    	double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
		Matrix D = new Matrix(d);
    	//D.show();
    	assertTrue(true);
    }
    
    

	/*
	 * Testing for runtime errors in solve method. Illegal deimensions
	 */ 
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
	

	/*
	 * Testing for runtime errors in solve method. MAtrix is singular
	 */
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
	
	/*
	 * Testing the solve method.
	 */
    @Test
    public void testSolve()  throws Exception{
    	
		Matrix A = Matrix.random(5, 5);
		
		Matrix B = Matrix.random(5, 1);
		A.solve(B);
		A.show();
		assertEquals(A.getData(0, 0), 1, 0);
    }


}

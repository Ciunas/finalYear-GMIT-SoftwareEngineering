package assignmentJUNIT.multiclass.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import assignmentJUNIT.multiclass.MobilePhone;
import assignmentJUNIT.multiclass.NumberDialed;
import assignmentJUNIT.multiclass.NumberQueue;
import assignmentJUNIT.multiclass.OldPhone;
import assignmentJUNIT.multiclass.Phone;
import assignmentJUNIT.multiclass.RestrictedSmartPhone;
import assignmentJUNIT.multiclass.SmartPhone;

public class PhoneTest {

	SmartPhone sp;
	MobilePhone mph;
	NumberDialed nd;
	RestrictedSmartPhone rph;

	@Before
	public void setUp() throws Exception {

		mph = new MobilePhone("Huawei");

		sp = new SmartPhone("Sony");

		rph = new RestrictedSmartPhone("Nokia");

	}

	@After
	public void tearDown() throws Exception {

		sp = null;
		rph = null;
		mph = null;
	}

	/*
	 * Test the default superconstructer
	 */
	@Test
	public void testSuperConstructer() {

		assertTrue(sp instanceof SmartPhone);
	}

	/*
	 * Test the Call method
	 */
	@Test
	public void testCallConstructer() {

		sp.call("0852738482");
		assertTrue(sp.callCalled);

	}

	/*
	 * Test the Call method, check if number put through internet
	 */
	@Test
	public void testCallConstructerInternat() {

		sp.call("0082738482");
		assertTrue(sp.callCalled);

	}

	/*
	 * Test the Call method checking last of the If statements, no 00 at start
	 * of number
	 */
	@Test
	public void testCallConstructer1() {

		sp.call("7852738482");
		assertTrue(sp.callCalled);

	}

	/*
	 * Test the Call method checking last of the If statements, no 00 at start
	 * of number
	 */
	@Test
	public void testGamePlay() {

		sp.playGame("snake");
		assertTrue(sp.playGameCalled);

	}

	/*
	 * Test the Call method checking last of the If statements, no 00 at start
	 * of number
	 */
	@Test
	public void testBrwosWeb() {

		sp.browseWeb("www.stuff.com");
		assertTrue(sp.browseWebCalled);
	}

	/*
	 * Test the Call method checking last of the If statements, no 00 at start
	 * of number
	 */
	@Test
	public void testfindPosition() {

		int temp = sp.findPosition();
		assertEquals(temp, 12, 0.01);
	}

	/*
	 * Test the default super constructer for Restricted smart phone
	 */
	@Test
	public void testSuperConstructerRestrictedSmartPhone() {

		assertTrue(rph instanceof SmartPhone);
	}

	/*
	 * Test the Call method checking last of the If statements, no 00 at start
	 * of number
	 */
	@Test
	public void testplayGameRestrictedSmartPhone() {

		rph.playGame("hahah");
		assertEquals(rph.message, "Error: Games are not playable from Restricted Smart Phones");
	}

	/*
	 * Test the Call method checking last of the If statements, no 00 at start
	 * of number
	 */
	@Test
	public void testPhoneInterface() {

		mph.call("731928329");
		assertEquals(rph.message, "Error: Games are not playable from Restricted Smart Phones");
	}

	/*
	 * Test the Call method checking last of the If statements, no 00 at start
	 * of number
	 */
	@Test
	public void testOldPhone() {

		rph.getBrand();
		assertEquals(rph.message, "Error: Games are not playable from Restricted Smart Phones");
	}


	/*
	 * Test the Call method checking last of the If statements, no 00 at start
	 * of number
	 */
	@Test
	public void testMobilePhoneDefautlConstructor() {

		assertTrue(mph instanceof OldPhone);
	}

	/*
	 * Test the Mobile Call and checks if there has been nolu one call made
	 */
	@Test
	public void testMobileCallConstructor() {

		mph.call("08592849");
		assertTrue(mph.callCalled);
	}

	/*
	 * Test the Mobile Call and checks if there has been more than two calles
	 * made
	 */
	@Test
	public void testMobileCallConstructorNull() {

		mph.call("0823094823");
		mph.call("80984234");
		assertTrue(mph.callCalled);
	}

	/*
	 * Test the mobile ring alram method
	 */
	@Test
	public void testMobileRingAlarm() {

		mph.ringAlarm("safa");
		assertTrue(mph.ringAlarmCalled);
	}

	/*
	 * Test the mobile PrintNUmbers Method.
	 */
	@Test
	public void testMobilePrintLastNumbers() {

		mph.printLastNumbers();
		assertTrue(mph.printLastNumbersCalled);
	}

	/*
	 * Test numberDialed, creation of an nunberdialed object
	 */
	@Test
	public void testNumberDialedCreation() {
		nd = new NumberDialed("0858947298374", 1);
		assertTrue(nd.NumberDialedCalled);
	}
	
	/*
	 * Test the setting of a new number into 
	 */
	@Test
	public void testsetPosition() {
		nd = new NumberDialed("0858947298374", 1);
		nd.setPosition(1);
		assertTrue(nd.setpositionCalled);
	}
	
	/*
//	 * Test the returning of the next number into a Numberdialed object
	 */
	@Test
	public void testNextPosition() {
		
		nd = new NumberDialed("0858947298374", 1);
		NumberDialed nd1;
		nd1 = nd.getNext();
		assertTrue(nd1 == nd);
	}

	/*
	 * Test the returning of the previous number into a Numberdialed object
	 */
	@Test
	public void testPreviousPosition() {
		
		nd = new NumberDialed("0858947298374", 1);
		NumberDialed nd1;
		nd1 = nd.getPrev();
		assertFalse(nd1 == nd);
	}
	
	/*
	 * Test the returning of the previous number into a Numberdialed object
	 */
	@Test
	public void testCreationNoArgsConstructor() {
		
		NumberDialed nd = new NumberDialed();
		assertTrue(nd instanceof NumberDialed);
	}
	
	/*
	 * Test the returning of the position on a number dialed
	 */
	@Test
	public void testGetPosition() {
		
		nd = new NumberDialed("0858947298374", 1);
		int temp = nd.getPosition();
		assertTrue(temp  == nd.getPosition());
	}
	
	
	/*
	 * Test the returning of the pphone number
	 */
	@Test
	public void testGetNumber() {
		
		nd = new NumberDialed("0858947298374", 1);
		String temp = nd.getNumber();
		assertTrue(temp  == nd.getNumber());
	}
	
	
	/*
	 * Test the returning of a creted phone number
	 */
	@Test
	public void testGetNumbertoString() {
		
		nd = new NumberDialed("0858947298374", 1);
		String temp = nd.toString();
		assertTrue(temp  == "Number: 0858947298374\nPosition: 1");
	}
	
	
	
	/*
	 * Test the insertion of a new number into a number Que
	 */
	@Test
	public void testInsertNumberintoQue() {
		
		NumberQueue nq = new NumberQueue();
		nd = new NumberDialed("0858947298374", 1);
		NumberDialed nd1 = new NumberDialed();
		
		nq.insert(nd);
		//nd1 =   nq.retrieve();
		
		assertFalse( false);
	}
	
	/*
	 * Test the creationof a numberQueObject
	 */
	@Test
	public void testNumberQueCreation() {
		
		NumberQueue nq = new NumberQueue();	
		assertTrue( nq.numb);
	}
	
	/*
	 * Test the numberQue is not null
	 */
	@Test
	public void testNumberQueNotNull() {
		
		NumberQueue nq = new NumberQueue();
		nd = new NumberDialed("0858947298374", 1);
			
		nq.setQueueHead(nd); 
		//nq.getQueueHead();
		nq.insert(nd);
		
		//assertTrue( nq.numb);
	}
	
	
	/*
	 * Test returning of the quetail
	 */
	@Test
	public void testNumberGetQueTail() {
		
		NumberQueue nq = new NumberQueue();
		nd = new NumberDialed("0858947298374", 1);
			
		nd = nq.getQueueTail(); 
		
		assertTrue( nq.numb);
	}
	
	
	/*
	 * Test returning of the quetail
	 */
	@Test
	public void testNumberSetQueTail() {
		
		NumberQueue nq = new NumberQueue();
		nd = new NumberDialed("0858947298374", 1);
			
		nq.setQueueTail(nd); 
		
		assertTrue( nq.numb);
	}
	
	/*
	 * Test returning of the quetail
	 */
	@Test
	public void testNumberPrintMethod() {
		
		NumberQueue nq = new NumberQueue();
		nd = new NumberDialed("0858947298374", 1);
			
		nq.printNumbers();		
		assertTrue( nq.numb);
	}
	
	
	/*
	 * Test retrieve of QUetail
	 */
	@Test
	public void testNumberRetriveMethod() {
		
		NumberQueue nq = new NumberQueue();
		nd = new NumberDialed("0858947298374", 1);
		nd.setPosition(0);
		nq.setQueueTail (nd);
		nq.setQueueHead(nd);
		nq.retrieve();		
		assertTrue( nq.numb);
	}
	
}

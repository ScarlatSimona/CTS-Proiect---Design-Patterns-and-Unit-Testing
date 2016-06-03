package testareAplicatie;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(TestAdaugareComponentaMeniu.class);
		suite.addTestSuite(TestBuilderComanda.class);
		suite.addTestSuite(TestCitireFisierMeniu.class);
		suite.addTestSuite(TestCodComanda.class);
		suite.addTestSuite(TestConstructorMeniu.class);
		suite.addTestSuite(TestGetListaComponenteMeniu.class);
		suite.addTestSuite(TestGetterCodComanda.class);
		suite.addTestSuite(TestGetterMasaComanda.class);
		suite.addTestSuite(TestSetterMasaComanda.class);
		suite.addTestSuite(TestSetterPreparateComandate.class);
		suite.addTestSuite(TestSetterPretTotalComanda.class);
		suite.addTestSuite(TestSimpleFactoryPrelucrare.class);
		suite.addTestSuite(TestSingleton.class);
		suite.addTestSuite(TestStergereComponentaMeniu.class);
		//$JUnit-END$
		return suite;
	}

}

package lab5.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({TestAddRemoveBooks.class, 
				TestAddRemoveMembers.class,
				TestFindClassString.class,
				TestBorrowBooks.class,
				TestBorrowAndReturnMessages.class,
				TestNotAvailableBook.class,
				TestRemoveMemberWithBooks.class,
				TestSingleton.class,
				TestController.class,
				BookTypeTest.class})
public class AllTests {
    // No need for test methods here; the suite will run the included classes
}


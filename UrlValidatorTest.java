/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalprojectB;

import junit.framework.TestCase;





/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest01() {

   	   String[] schemes = {"http","https"};
	   UrlValidator urlVal = new UrlValidator(schemes);
	   // Valid URL
	   assertTrue(urlVal.isValid("http://www.amazon.com/pathQuery#Fragment"));
	   // Invalid Schemes
	   assertFalse(urlVal.isValid("htt://www.amazon.com/pathQuery#Fragment"));
	   assertFalse(urlVal.isValid("httpss://www.amazon.com/pathQuery#Fragment"));
	   // Invalid Host Name
	   assertFalse(urlVal.isValid("http:///pathQuery#Fragment"));
	   // Invalid path, "//"" not allowed
	   assertFalse(urlVal.isValid("http://www.amazon.com//pathQuery#Fragment"));
	   // Valid Query, null query returns true.
	   assertTrue(urlVal.isValid("http://www.amazon.com/path"));
	   // BUG, the beginning of the Query should be denoted by "?", but it is disallowed.
	   assertTrue(urlVal.isValid("http://www.amazon.com/path?Query#Fragment")); 
   }
      
   public void testManualTest02() {
   
	   UrlValidator urlVal = new UrlValidator(UrlValidator.ALLOW_2_SLASHES);
	   // Valid URL
	   assertTrue(urlVal.isValid("http://www.amazon.com/pathQuery#Fragment"));
	   // Valid Path, "//" allowed
	   assertTrue(urlVal.isValid("http://www.amazon.com//pathQuery#Fragment"));
	   // BUG. Invalid Path, ALLOW_2_SLASHES states that it allows 2 slashes in the path, adding more should be invalid but is not.
	   assertFalse(urlVal.isValid("http://www.amazon.com////////pathQuery#Fragment"));
	   // Invalid Path, zero path slashes 
	   assertFalse(urlVal.isValid("http://www.amazon.compathQuery#Fragment"));
   }
   
   public void testManualTest03() {
   
	   UrlValidator urlVal = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	   // Valid Schemes, all properly formatted schemes should be valid.
	   assertTrue(urlVal.isValid("http://www.amazon.com/path.htmlQuery#Fragment"));
	   assertTrue(urlVal.isValid("ht://www.amazon.com/path.htmlQuery#Fragment"));
	   assertTrue(urlVal.isValid("htttps://www.amazon.com/path.htmlQuery#Fragment"));
	   assertTrue(urlVal.isValid("httttttttsssssssss://www.amazon.com/path.htmlQuery#Fragment"));
	   // Invalid scheme, numbers are not proper format?
	   assertFalse(urlVal.isValid("12345://www.amazon.com/path.htmlQuery#Fragment"));
	   // Invalid scheme, scheme cannot be null
	   assertFalse(urlVal.isValid("://www.amazon.com/path.htmlQuery#Fragment"));
   }

   public void testManualTest04() {
   
	   UrlValidator urlVal = new UrlValidator(UrlValidator.NO_FRAGMENTS);
	   // Valid URL, no fragments
	   assertTrue(urlVal.isValid("http://www.amazon.com/path.htmlQuery"));
	   // Invalid URL, fragments present
	   assertFalse(urlVal.isValid("http://www.amazon.com/path.html#Fragment"));
   }
   public void testManualTest05() {
   
	   UrlValidator urlVal = new UrlValidator(UrlValidator.ALLOW_LOCAL_URLS);
	   // BUG, Valid Local URL, does not accept.
	   assertTrue(urlVal.isValid("http://amazon/"));
	   // Valid Local Url
	   assertTrue(urlVal.isValid("http://amazon/path.html"));
   }

   public void testYourFirstPartition()
   {
	   
   }
   
   public void testYourSecondPartition(){
	   
   }
   
   
   public void testIsValid()
   {
	   for(int i = 0;i<10000;i++)
	   {
		   
	   }
   }
   
   public void testAnyOtherUnitTest()
   {
	   
   }
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   

}

package org.eurocris.openaire.cris.validator.metadataTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.URL;

import org.eurocris.openaire.cris.validator.CRISValidator;
import org.junit.Test;

/**
 * Test the behaviour of the CRISValidator in diverse edge cases.
 * @author jdvorak001
 */
public class MetadataFormatTest {

	/**
	 * Test that {@link CRISValidator} reports when no OpenAIRE CRIS metadata format is offered.
	 * @see (2a) in CHECKS.md
	 * @throws Exception in case of some error
	 */
	@Test
	public void testCheck2a() throws Exception {
		final URL url = MetadataFormatTest.class.getResource( "check_2a/" );
		final CRISValidator validator = new CRISValidator( url );
		validator.check000_Identify();
		try {
			validator.check010_MetadataFormats();
			fail( "Problem: check (2a) undetected" );
		} catch ( final AssertionError e ) {
			assertEquals( "Metadata format for the OpenAIRE Guidelines for CRIS Managers not present (2a)", e.getMessage() );
		}
	}

	/**
	 * Test that {@link CRISValidator} reports when an OpenAIRE CRIS metadata format has a wrong namespace URI.
	 * @see (2b) in CHECKS.md
	 * @throws Exception in case of some error
	 */
	@Test
	public void testCheck2b() throws Exception {
		final URL url = MetadataFormatTest.class.getResource( "check_2b/" );
		final CRISValidator validator = new CRISValidator( url );
		validator.check000_Identify();
		try {
			validator.check010_MetadataFormats();
			fail( "Problem: check (2b) undetected" );
		} catch ( final AssertionError e ) {
			assertEquals( "The metadata NS for prefix oai_cerif_openaire does not start with " + CRISValidator.OPENAIRE_CERIF_XMLNS_PREFIX + " (2b)", e.getMessage() );
		}
	}

	/**
	 * Test that {@link CRISValidator} reports when an OpenAIRE CRIS XML namespace has a wrong metadata format.
	 * @see (2c) in CHECKS.md
	 * @throws Exception in case of some error
	 */
	@Test
	public void testCheck2c() throws Exception {
		final URL url = MetadataFormatTest.class.getResource( "check_2c/" );
		final CRISValidator validator = new CRISValidator( url );
		validator.check000_Identify();
		try {
			validator.check010_MetadataFormats();
			fail( "Problem: check (2c) undetected" );
		} catch ( final AssertionError e ) {
			assertEquals( "The metadata prefix for XML namespace https://www.openaire.eu/cerif-profile/1.2/ does not start with " + CRISValidator.OAI_CERIF_OPENAIRE__METADATA_PREFIX + " (2c)", e.getMessage() );
		}
	}

	/**
	 * Test that {@link CRISValidator} reports a non-unique metadata format.
	 * @see (2d) in CHECKS.md
	 * @throws Exception in case of some error
	 */
	@Test
	public void testCheck2d() throws Exception {
		final URL url = MetadataFormatTest.class.getResource( "check_2d/" );
		final CRISValidator validator = new CRISValidator( url );
		validator.check000_Identify();
		try {
			validator.check010_MetadataFormats();
			fail( "Problem: check (2d) undetected" );
		} catch ( final AssertionError e ) {
			assertEquals( "Metadata prefix not unique (2d); value: oai_cerif_openaire", e.getMessage() );
		}
	}

	/**
	 * Test that {@link CRISValidator} reports a non-unique metadata namespace URI.
	 * @see (2e) in CHECKS.md
	 * @throws Exception in case of some error
	 */
	@Test
	public void testCheck2e() throws Exception {
		final URL url = MetadataFormatTest.class.getResource( "check_2e/" );
		final CRISValidator validator = new CRISValidator( url );
		validator.check000_Identify();
		try {
			validator.check010_MetadataFormats();
			fail( "Problem: check (2e) undetected" );
		} catch ( final AssertionError e ) {
			assertEquals( "Metadata namespace not unique (2e); value: https://www.openaire.eu/cerif-profile/1.2/", e.getMessage() );
		}
	}

	/**
	 * Test that {@link CRISValidator} reports a non-unique XML Schema URL.
	 * @see (2f) in CHECKS.md
	 * @throws Exception in case of some error
	 */
	@Test
	public void testCheck2f() throws Exception {
		final URL url = MetadataFormatTest.class.getResource( "check_2f/" );
		final CRISValidator validator = new CRISValidator( url );
		validator.check000_Identify();
		try {
			validator.check010_MetadataFormats();
			fail( "Problem: check (2f) undetected" );
		} catch ( final AssertionError e ) {
			assertEquals( "Metadata schema location not unique (2f); value: https://www.openaire.eu/schema/cris/1.2/openaire-cerif-profile.xsd", e.getMessage() );
		}
	}

}

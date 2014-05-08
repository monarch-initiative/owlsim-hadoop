/**
 * 
 */
package disease_comparison;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author slharris
 *
 */
public class MousePhenotypeTest {

	Ontology simple = null;
	
	@Before
	public void init() throws Exception {
		simple = new Ontology(
				"src/test/resources/mp-subset-1-labels.tsv",
				"src/test/resources/mp-subset-1-edges.tsv",
				"src/test/resources/mgi-gene2mp-subset-1-labels.tsv",
				"src/test/resources/mgi-gene2mp-subset-1.tsv"

			);
	}
	
	/**
	 * Test method for {@link disease_comparison.Ontology#computeLCS(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testComputeLCS() {
		assertEquals("MP:0003631", simple.computeLCS("MP:0000857","MP:0003635"));
	}

}

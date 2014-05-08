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
public class OntologyTest {

	Ontology simple = null;
	
	@Before
	public void init() throws Exception {
		simple = new Ontology(
				"src/test/resources/mp-subset-1-labels.tsv",
				"src/test/resources/mp-subset-1-edges.tsv",
				"src/test/resources/mgi-gene2mp-subset-1.tsv",
				"src/test/resources/mgi-gene2mp-subset-1-labels.tsv"
			);
	}
	
	/**
	 * Test method for {@link disease_comparison.Ontology#computeLCS(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testComputeLCS() {
		assertEquals("HMC:3141", simple.computeLCS("HMC:2222","HMC:3333"));
		assertEquals("HMC:3333", simple.computeLCS("HMC:1111","HMC:3333"));
	}

//	/**
//	 * Test method for {@link disease_comparison.Ontology#getGraph()}.
//	 */
//	@Test
//	public void testGetGraph() {
//		fail("Not yet implemented");
//	}

	/**
	 * Test method for {@link disease_comparison.Ontology#getNodeMap()}.
	 */
	@Test
	public void testGetNodeMap() {
		assertEquals("AAAAAAAAAAA!!!", simple.getNodeMap().get("HMC:0042").getName());
		assertEquals(simple.getNodeMap().get("HMC:3141").getName(), "BBBBBBBBBBB!!!");
		assertEquals(simple.getNodeMap().get("HMC:1111").getName(), "CCCCCCCCCCC!!!");
		assertEquals(simple.getNodeMap().get("HMC:2222").getName(), "DDDDDDDDDDD!!!");
		assertEquals(simple.getNodeMap().get("HMC:3333").getName(), "EEEEEEEEEEE!!!");
	}

	/**
	 * Test method for {@link disease_comparison.Ontology#getAnnotationMap()}.
	 */
	@Test
	public void testGetAnnotationMap() {
		assertTrue(simple.getAnnotationMap().get("PI:3").contains("HMC:2222"));
		assertTrue(simple.getAnnotationMap().get("PI:3").contains("HMC:3333"));
		assertTrue(!simple.getAnnotationMap().get("PI:3").contains("HMC:3141"));
	}

	/**
	 * Test method for {@link disease_comparison.Ontology#getAnnotationNames()}.
	 */
	@Test
	public void testGetAnnotationNames() {
		assertEquals(simple.getAnnotationNames().get("PI:1"), "Spam Deficiency");
		assertEquals(simple.getAnnotationNames().get("PI:2"), "Sleep Deprivation");
		assertEquals(simple.getAnnotationNames().get("PI:3"), "Pyromania");
		assertEquals(simple.getAnnotationNames().get("PI:4"), "Social Anxiety");
		assertEquals(simple.getAnnotationNames().get("PI:5"), "Other");
	}

	/**
	 * Test method for {@link disease_comparison.Ontology#getRoot()}.
	 */
	@Test
	public void testGetRoot() {
		assertEquals(simple.getRoot(), "HMC:0042");
	}

//	/**
//	 * Test method for {@link disease_comparison.Ontology#getOptions()}.
//	 */
//	@Test
//	public void testGetOptions() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link disease_comparison.Ontology#getImportantNodes()}.
//	 */
//	@Test
//	public void testGetImportantNodes() {
//		fail("Not yet implemented");
//	}

}

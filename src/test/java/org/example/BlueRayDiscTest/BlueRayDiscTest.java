package org.example.BlueRayDiscTest;




import org.example.BlueRayDisc;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BlueRayDiscTest {

    private BlueRayDisc disc;
    private final String discName = "MyCollection";

    @BeforeAll
    static void beforeAll() {
        System.out.println("Начало тестирования класса BlueRayDisc");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Завершение тестирования класса BlueRayDisc");
    }

    @BeforeEach
    void setUp() {
        disc = new BlueRayDisc(discName);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Тест завершен");
    }

    @Test
    void testDiscCreation() {
        assertNotNull(disc);
        assertEquals(discName, disc.getDiscName());
        assertTrue(disc.getCatalogs().isEmpty());
    }

    @Test
    void testAddCatalog() {
        BlueRayDisc.Catalog catalog = disc.createCatalog("Movies");
        disc.addCatalog(catalog);

        assertEquals(1, disc.getCatalogs().size());
        assertEquals("Movies", disc.getCatalogs().get(0).getCatalogName());
    }

    @Test
    void testAddNullCatalog() {
        disc.addCatalog(null);
        assertTrue(disc.getCatalogs().isEmpty());
    }

    @Test
    void testCatalogOperations() {
        BlueRayDisc.Catalog catalog = disc.createCatalog("Music");


        BlueRayDisc.Catalog.SubCatalog subCatalog = catalog.createSubCatalog("Rock");
        catalog.addSubCatalog(subCatalog);
        assertEquals(1, catalog.getSubCatalogs().size());

        BlueRayDisc.Catalog.Record record = catalog.createRecord("Thriller", "Michael Jackson");
        subCatalog.addRecord(record);
        catalog.addRecord(record);

        assertEquals(1, subCatalog.getRecords().size());
        assertEquals(1, catalog.getRecords().size());
    }

    @Test
    void testAddNullSubCatalog() {
        BlueRayDisc.Catalog catalog = disc.createCatalog("Test");
        catalog.addSubCatalog(null);
        assertTrue(catalog.getSubCatalogs().isEmpty());
    }

    @Test
    void testAddNullRecord() {
        BlueRayDisc.Catalog catalog = disc.createCatalog("Test");
        catalog.addRecord(null);
        assertTrue(catalog.getRecords().isEmpty());
    }

    @Test
    void testToString() {
        BlueRayDisc.Catalog catalog = disc.createCatalog("Movies");
        disc.addCatalog(catalog);

        String expectedDisc = "BlueRayDisc: " + discName + ", catalogs: 1";
        assertEquals(expectedDisc, disc.toString());

        String expectedCatalog = "Catalog: Movies, subCatalogs: 0, records: 0";
        assertEquals(expectedCatalog, catalog.toString());

        BlueRayDisc.Catalog.SubCatalog subCatalog = catalog.createSubCatalog("Action");
        String expectedSubCatalog = "SubCatalog: Action, records: 0";
        assertEquals(expectedSubCatalog, subCatalog.toString());

        BlueRayDisc.Catalog.Record record = catalog.createRecord("Matrix", "Sci-fi");
        String expectedRecord = "Record: Matrix (content: Sci-fi)";
        assertEquals(expectedRecord, record.toString());
    }

    @Test
    void testCreateMethods() {
        BlueRayDisc.Catalog catalog = disc.createCatalog("Games");
        assertNotNull(catalog);
        assertEquals("Games", catalog.getCatalogName());

        BlueRayDisc.Catalog.SubCatalog subCatalog = catalog.createSubCatalog("RPG");
        assertNotNull(subCatalog);
        assertEquals("RPG", subCatalog.getSubCatalogName());

        BlueRayDisc.Catalog.Record record = catalog.createRecord("Witcher", "RPG game");
        assertNotNull(record);
        assertEquals("Witcher", record.getRecordName());
        assertEquals("RPG game", record.getContent());
    }

    @Test
    void testGetMethods() {
        BlueRayDisc.Catalog catalog = disc.createCatalog("Books");
        disc.addCatalog(catalog);

        BlueRayDisc.Catalog.SubCatalog subCatalog = catalog.createSubCatalog("Fantasy");
        catalog.addSubCatalog(subCatalog);

        BlueRayDisc.Catalog.Record record = catalog.createRecord("LOTR", "Tolkien");
        subCatalog.addRecord(record);
        catalog.addRecord(record);


        assertEquals(1, disc.getCatalogs().size());
        assertEquals("Books", disc.getCatalogs().get(0).getCatalogName());

        assertEquals(1, catalog.getSubCatalogs().size());
        assertEquals("Fantasy", catalog.getSubCatalogs().get(0).getSubCatalogName());

        assertEquals(1, subCatalog.getRecords().size());
        assertEquals("LOTR", subCatalog.getRecords().get(0).getRecordName());

        assertEquals(1, catalog.getRecords().size());
        assertEquals("LOTR", catalog.getRecords().get(0).getRecordName());
    }
}
/*
public class BlueRayDiscTest {
}

 */

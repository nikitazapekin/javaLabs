package org.example.BlueRayDiscTest;

import org.example.BlueRayDisc;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BlueRayDiscTest {

    private BlueRayDisc disc;
    private final String discName = "МояКоллекция";

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
        BlueRayDisc.Catalog catalog = disc.createCatalog("Фильмы");
        disc.addCatalog(catalog);

        assertEquals(1, disc.getCatalogs().size());
        assertEquals("Фильмы", disc.getCatalogs().get(0).getCatalogName());
    }

    @Test
    void testAddNullCatalog() {
        disc.addCatalog(null);
        assertTrue(disc.getCatalogs().isEmpty());
    }

    @Test
    void testCatalogOperations() {
        BlueRayDisc.Catalog catalog = disc.createCatalog("Музыка");

        BlueRayDisc.Catalog.SubCatalog subCatalog = catalog.createSubCatalog("Рок");
        catalog.addSubCatalog(subCatalog);
        assertEquals(1, catalog.getSubCatalogs().size());

        BlueRayDisc.Catalog.Record record = catalog.createRecord("Thriller", "Майкл Джексон");
        subCatalog.addRecord(record);
        catalog.addRecord(record);

        assertEquals(1, subCatalog.getRecords().size());
        assertEquals(1, catalog.getRecords().size());
    }

    @Test
    void testAddNullSubCatalog() {
        BlueRayDisc.Catalog catalog = disc.createCatalog("Тест");
        catalog.addSubCatalog(null);
        assertTrue(catalog.getSubCatalogs().isEmpty());
    }

    @Test
    void testAddNullRecord() {
        BlueRayDisc.Catalog catalog = disc.createCatalog("Тест");
        catalog.addRecord(null);
        assertTrue(catalog.getRecords().isEmpty());
    }

    @Test
    void testToString() {
        BlueRayDisc.Catalog catalog = disc.createCatalog("Фильмы");
        disc.addCatalog(catalog);

        String expectedDisc = "BlueRayDisc: " + discName + ", catalogs: 1";
        assertEquals(expectedDisc, disc.toString());

        String expectedCatalog = "Catalog: Фильмы, subCatalogs: 0, records: 0";
        assertEquals(expectedCatalog, catalog.toString());

        BlueRayDisc.Catalog.SubCatalog subCatalog = catalog.createSubCatalog("Боевики");
        String expectedSubCatalog = "SubCatalog: Боевики, records: 0";
        assertEquals(expectedSubCatalog, subCatalog.toString());

        BlueRayDisc.Catalog.Record record = catalog.createRecord("Матрица", "Фантастика");
        String expectedRecord = "Record: Матрица (content: Фантастика)";
        assertEquals(expectedRecord, record.toString());
    }

    @Test
    void testCreateMethods() {
        BlueRayDisc.Catalog catalog = disc.createCatalog("Игры");
        assertNotNull(catalog);
        assertEquals("Игры", catalog.getCatalogName());

        BlueRayDisc.Catalog.SubCatalog subCatalog = catalog.createSubCatalog("RPG");
        assertNotNull(subCatalog);
        assertEquals("RPG", subCatalog.getSubCatalogName());

        BlueRayDisc.Catalog.Record record = catalog.createRecord("Ведьмак", "RPG игра");
        assertNotNull(record);
        assertEquals("Ведьмак", record.getRecordName());
        assertEquals("RPG игра", record.getContent());
    }

    @Test
    void testGetMethods() {
        BlueRayDisc.Catalog catalog = disc.createCatalog("Книги");
        disc.addCatalog(catalog);

        BlueRayDisc.Catalog.SubCatalog subCatalog = catalog.createSubCatalog("Фэнтези");
        catalog.addSubCatalog(subCatalog);

        BlueRayDisc.Catalog.Record record = catalog.createRecord("Властелин Колец", "Толкин");
        subCatalog.addRecord(record);
        catalog.addRecord(record);

        assertEquals(1, disc.getCatalogs().size());
        assertEquals("Книги", disc.getCatalogs().get(0).getCatalogName());

        assertEquals(1, catalog.getSubCatalogs().size());
        assertEquals("Фэнтези", catalog.getSubCatalogs().get(0).getSubCatalogName());

        assertEquals(1, subCatalog.getRecords().size());
        assertEquals("Властелин Колец", subCatalog.getRecords().get(0).getRecordName());

        assertEquals(1, catalog.getRecords().size());
        assertEquals("Властелин Колец", catalog.getRecords().get(0).getRecordName());
    }
}

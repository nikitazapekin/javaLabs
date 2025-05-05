package org.example;

import java.util.ArrayList;
import java.util.List;

public class BlueRayDisc {
    private final String discName;
    private final List<Catalog> catalogs;

    public BlueRayDisc(String discName) {
        this.discName = discName;
        this.catalogs = new ArrayList<>();
    }

    public class Catalog {
        private final String catalogName;
        private final List<SubCatalog> subCatalogs;
        private final List<Record> records;

        public Catalog(String catalogName) {
            this.catalogName = catalogName;
            this.subCatalogs = new ArrayList<>();
            this.records = new ArrayList<>();
        }

        public class SubCatalog {
            private final String subCatalogName;
            private final List<Record> records;

            public SubCatalog(String subCatalogName) {
                this.subCatalogName = subCatalogName;
                this.records = new ArrayList<>();
            }

            public void addRecord(Record record) {
                if (record != null) {
                    records.add(record);
                }
            }

            public List<Record> getRecords() {
                return new ArrayList<>(records);
            }

            public String getSubCatalogName() {
                return subCatalogName;
            }

            @Override
            public String toString() {
                return "SubCatalog: " + subCatalogName + ", records: " + records.size();
            }
        }

        public class Record {
            private final String recordName;
            private final String content;

            public Record(String recordName, String content) {
                this.recordName = recordName;
                this.content = content;
            }

            public String getRecordName() {
                return recordName;
            }

            public String getContent() {
                return content;
            }

            @Override
            public String toString() {
                return "Record: " + recordName + " (content: " + content + ")";
            }
        }

        public void addSubCatalog(SubCatalog subCatalog) {
            if (subCatalog != null) {
                subCatalogs.add(subCatalog);
            }
        }

        public void addRecord(Record record) {
            if (record != null) {
                records.add(record);
            }
        }

        public SubCatalog createSubCatalog(String name) {
            return new SubCatalog(name);
        }

        public Record createRecord(String name, String content) {
            return new Record(name, content);
        }

        public List<SubCatalog> getSubCatalogs() {
            return new ArrayList<>(subCatalogs);
        }

        public List<Record> getRecords() {
            return new ArrayList<>(records);
        }

        public String getCatalogName() {
            return catalogName;
        }

        @Override
        public String toString() {
            return "Catalog: " + catalogName +
                    ", subCatalogs: " + subCatalogs.size() +
                    ", records: " + records.size();
        }
    }

    public void addCatalog(Catalog catalog) {
        if (catalog != null) {
            catalogs.add(catalog);
        }
    }

    public Catalog createCatalog(String name) {
        return new Catalog(name);
    }

    public List<Catalog> getCatalogs() {
        return new ArrayList<>(catalogs);
    }

    public String getDiscName() {
        return discName;
    }

    @Override
    public String toString() {
        return "BlueRayDisc: " + discName + ", catalogs: " + catalogs.size();
    }
}
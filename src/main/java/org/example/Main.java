package org.example;

public class Main {
    public static void main(String[] args) {

        BlueRayDisc disc = new BlueRayDisc("МояКоллекцияФильмов");


        BlueRayDisc.Catalog movies = disc.createCatalog("Фильмы");


        BlueRayDisc.Catalog.SubCatalog actionMovies = movies.createSubCatalog("Боевики");
        BlueRayDisc.Catalog.SubCatalog comedyMovies = movies.createSubCatalog("Комедии");


        BlueRayDisc.Catalog.Record matrix = movies.createRecord("Матрица", "Фантастический боевик");
        BlueRayDisc.Catalog.Record johnWick = movies.createRecord("Джон Уик", "Боевик с Киану Ривзом");
        actionMovies.addRecord(matrix);
        actionMovies.addRecord(johnWick);


        comedyMovies.addRecord(movies.createRecord("Мальчишник в Вегасе", "Смешная комедия"));
        comedyMovies.addRecord(movies.createRecord("Суперплохие", "Подростковая комедия"));

        movies.addRecord(movies.createRecord("Начало", "Фильм с запутанным сюжетом"));


        disc.addCatalog(movies);


        BlueRayDisc.Catalog music = disc.createCatalog("Музыка");
        music.addRecord(music.createRecord("Thriller", "Альбом Майкла Джексона"));
        disc.addCatalog(music);


        System.out.println("=== Информация о диске ===");
        System.out.println(disc);

        System.out.println("\n=== Каталоги ===");
        for (BlueRayDisc.Catalog catalog : disc.getCatalogs()) {
            System.out.println(catalog);


            for (BlueRayDisc.Catalog.SubCatalog subCatalog : catalog.getSubCatalogs()) {
                System.out.println("  " + subCatalog);

                for (BlueRayDisc.Catalog.Record record : subCatalog.getRecords()) {
                    System.out.println("    " + record);
                }
            }


            System.out.println("  Записи в основном каталоге:");
            for (BlueRayDisc.Catalog.Record record : catalog.getRecords()) {
                System.out.println("    " + record);
            }
        }
    }
}

/*
package org.example;




public class Main {
    public static void main(String[] args) {

        BlueRayDisc disc = new BlueRayDisc("MyMovieCollection");


        BlueRayDisc.Catalog movies = disc.createCatalog("Movies");


        BlueRayDisc.Catalog.SubCatalog actionMovies = movies.createSubCatalog("Action");
        BlueRayDisc.Catalog.SubCatalog comedyMovies = movies.createSubCatalog("Comedy");


        BlueRayDisc.Catalog.Record matrix = movies.createRecord("Matrix", "Sci-fi action movie");
        BlueRayDisc.Catalog.Record johnWick = movies.createRecord("John Wick", "Action movie with Keanu Reeves");
        actionMovies.addRecord(matrix);
        actionMovies.addRecord(johnWick);


        comedyMovies.addRecord(movies.createRecord("The Hangover", "Funny comedy movie"));
        comedyMovies.addRecord(movies.createRecord("Superbad", "Teen comedy"));

        movies.addRecord(movies.createRecord("Inception", "Mind-bending movie"));


        disc.addCatalog(movies);


        BlueRayDisc.Catalog music = disc.createCatalog("Music");
        music.addRecord(music.createRecord("Thriller", "Album by Michael Jackson"));
        disc.addCatalog(music);


        System.out.println("=== Disc Info ===");
        System.out.println(disc);

        System.out.println("\n=== Catalogs ===");
        for (BlueRayDisc.Catalog catalog : disc.getCatalogs()) {
            System.out.println(catalog);


            for (BlueRayDisc.Catalog.SubCatalog subCatalog : catalog.getSubCatalogs()) {
                System.out.println("  " + subCatalog);

                for (BlueRayDisc.Catalog.Record record : subCatalog.getRecords()) {
                    System.out.println("    " + record);
                }
            }


            System.out.println("  Records in main catalog:");
            for (BlueRayDisc.Catalog.Record record : catalog.getRecords()) {
                System.out.println("    " + record);
            }
        }




        }

    }
*/
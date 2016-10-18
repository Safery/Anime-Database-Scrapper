# Anime-Database-Scrapper
Scrap all available Anime information to local server from MyAnimeList.


# What is this?
This is an data scrapper that scraps all available Anime to localserver. The database are scrapped from Hummingbird server but you will note that the "id" which is unique to each Anime information is same as MyAnimeList data.

# How to use this?
* Do NOT download the file and just use the src, If you are not experienced how to import projects to Java, this will not work. If you know how to use Eclipse or any other Java IDE, feel free to open the files in src folder.
* Import the library from the libs folder to your Java project.
* Find the main method in Scrapper.java, note the comments, read them and undo the two line. One line will download all Anime database and the other line will create a genre folder and put specific Anime at their relevant genre.

# How does it work?
The scrapper downloads all Anime data into a JSON files and saves it on the root directory of your Java project. Do not worry, it will create a new directory call "animeDatabase" and save all Anime. Each JSON file will have unique ID, which is used to identify Anime (This ID are same ID you see at the end of each MyAnimeList).

There is a optional method to create a genre folder and create different genre directories and store related anime (JSON file) in those folder. Note, to make this work, you must have the animeDatabase downloaded.

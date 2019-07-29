# headlines-challenge

The api key is currently stored directly in the gradle file (nb. i didn't commit the api key), but it needs to be manually pasted in as a buildconfig value to work.

I would have set up a local file for keys if i had the time.

The app is very barebones, and only displays the first page of results in a simple listview.

The main feature it has is extensibility due to the fact that the dagger android plugin is set up, so the different components are fairly decoupled. 

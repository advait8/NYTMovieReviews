# NYTMovieReviews
To build this app: 
  add 
  nytimes_api_key="<API_KEY>"
  to local.properties
  
  This app uses MVVM design pattern in conjunction with
  1) Retrofit 2
  2) Glide 
  3) Android Lifecycle components : a) LiveData
                                    b) Data Binding
  4) Robolectric for unit testing.
  **Robolectric test is failing due to compatibility issue between robolectric version and Android studio. Need to debug further to get the tests running**

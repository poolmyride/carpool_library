# How to integrate Poolmyride Carpool Library into your App

This is a sample project demonstrating integration of Poolmyride Android Library for fetching carpools. 
Developers can fetch 

1. Carpools on a specific route
1. Carpools on a specific location
1. Latest 50 Carpools
1. User's looking for ride "Right Now" on a particular location 

## Pre-Requisite
Add following in your build.gradle

    compile 'carpool.delvelogic.library:pmr-carpools:0.0.7'
    
After adding the above line make sure you initialize the library in your launcher activity with the context

    CarpoolRequest.init(context)

### Fetch Carpools on a route

      CarpoolRequest.fetchCarpoolsOnRoute(ctx, loc1, loc2, "Loc1 Place Name", "Loc2 Place Name", new CarpoolRequest.CarpoolInterface() {
            @Override
            public void onSuccess(ArrayList<CarPool> carpools) {
                Toast.makeText(ctx, carpools.size() + " carpools searched", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(JSONObject jsonObject) {
                Toast.makeText(ctx, "Some Error Ocurred", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLocationError() {
                Toast.makeText(ctx, "Location Error", Toast.LENGTH_SHORT).show();
            }
        });



### Fetch Carpools on a specific location

Create a Location Object and fetch nearby carpools

     Location loc = new Location("Rajouri");
        loc.setLatitude(28.641529);
        loc.setLongitude(77.120915);

     CarpoolRequest.fetchNearbyCarpools(ctx, loc, new CarpoolRequest.CarpoolInterface(){
            @Override
            public void onSuccess(ArrayList<CarPool> carpools) {
                Toast.makeText(ctx, carpools.size() + " carpools", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(JSONObject jsonObject) {
                Toast.makeText(ctx, "Some Error Ocurred", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLocationError() {
                Toast.makeText(ctx, "Location Error", Toast.LENGTH_SHORT).show();
            }
        });

### Fetch Latest Carpools 

       CarpoolRequest.fetchLatestCarpools(this, new CarpoolRequest.CarpoolInterface() {
            @Override
            public void onSuccess(ArrayList<CarPool> carpools) {

            }

            @Override
            public void onError(JSONObject jsonObject) {

            }

            @Override
            public void onLocationError() {

            }
        });

### Fetch Realtime Users near a location looking to share ride 


    CarpoolRequest.fetchUsersTravellingRightNow(ctx, loc, new CarpoolRequest.CarpoolInterface() {
            @Override
            public void onSuccess(ArrayList<CarPool> carpools) {
                
            }

            @Override
            public void onError(JSONObject jsonObject) {

            }

            @Override
            public void onLocationError() {

            }
        });


![Carpool Menu](http://s8.postimg.org/7b0tv1md1/menu.jpg)
![List of Carpools](http://s21.postimg.org/t1envo5mv/carpools.jpg)
![Realtime users](http://s12.postimg.org/9d4cejr6l/realtime.jpg)

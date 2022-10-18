
# Table of Contents

1.  [Vehicle-Rental](#org938e0ac)
    1.  [Entities](#org9a39f78)
        1.  [Users](#orgd49a4c5)
        2.  [Vehicles](#orgc405384)
        3.  [Makers](#org9756ed5)
        4.  [Rent](#org0c76dd7)
    2.  [use-cases](#orgc0516b9)
        1.  [User can](#org07c2f7c)
        2.  [User as Renter can](#org3dad1a8)
        3.  [User as Owner can](#orgfd54091)
        4.  [User as Admin can](#org74e2508)


<a id="org938e0ac"></a>

# Vehicle-Rental


<a id="org9a39f78"></a>

## Entities


<a id="orgd49a4c5"></a>

### Users

1.  username

2.  name

3.  gender (enum)

4.  email

5.  phoneNumber

6.  address


<a id="orgc405384"></a>

### Vehicles

1.  makerId

2.  model

3.  ownerId

4.  type (enum)

5.  image

6.  address

7.  registerationNumber

8.  color

9.  capacity

10. condition (enum)

11. status (enum)

12. hourlyRate

13. averageRating


<a id="org9756ed5"></a>

### Makers

1.  name

2.  country


<a id="org0c76dd7"></a>

### Rent

1.  vehicleId

2.  ownerId

3.  renterId

4.  requestDate

5.  requestStatus

6.  rentDate

7.  returnDate

8.  duration

9.  rating

10. cost


<a id="orgc0516b9"></a>

## use-cases


<a id="org07c2f7c"></a>

### User can

1.  register account

2.  edit details

3.  delete account

4.  view others profile


<a id="org3dad1a8"></a>

### User as Renter can

1.  list available vehicles (by criteria)

2.  get vehicle details

3.  send rent request

4.  list sent requests

5.  cancel rent request

6.  return vehicle


<a id="orgfd54091"></a>

### User as Owner can

1.  register vehicle

2.  list rent requests

3.  accept|reject rent request


<a id="org74e2508"></a>

### User as Admin can

1.  maintain users

    1.  ban
    
    2.  unban
    
    3.  review

2.  show dashboard


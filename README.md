# Welcome to Clinic Web App v.2 🏥

**<mark>Go Live! ▶️ <a href="http://ec2-35-172-114-155.compute-1.amazonaws.com:8080/">here</a></mark>**

## What this app is?

> This is a web application template for any clinic, with features like:
> 
> - About us, basic info about the clinic
> - Out team, introducing therapists
> - Contact us
> - Make Appointment
> - Sign in & Sign up w/Remember me
> - User page
>     - My Appointments
>     - My Profile
> - Admin page
>     - Dashboard w/total numbers of bookings by the term
>     - Booking list
>     - User list

### How to use

**Clicking imgs will send you to the same page of the website** *(you'll be asked to either register or log in to access some of the pages)*.

#### Main Page
[![image](https://user-images.githubusercontent.com/59325382/160702102-15c5de48-46cf-46b1-a9b0-fba0d7bcd804.png)](http://ec2-35-172-114-155.compute-1.amazonaws.com:8080/)
Use the navbar on the top of the page to browse the main page.  
If you go to the Our team section, you can see the therapists of the clinic, and make an appointment with them by clicking the profile picture.

#### User Page
[![image](https://user-images.githubusercontent.com/59325382/160704456-2fe3e908-cc0f-4b0d-873e-8d27a48dc8cf.png)](http://ec2-35-172-114-155.compute-1.amazonaws.com:8080/booking/openUserBookingList)
Use the navbar on the left of the page to browse the user page.  
You can Create, Read, Update, Delete the appointments right here *(don't forget to select the therapist and date to enable the Confirm Appointment button!)*.  
My Profile page is pretty much the same: 

[![image](https://user-images.githubusercontent.com/59325382/160706606-c1812811-4dce-4963-b24c-f76fc8752a42.png)](http://ec2-35-172-114-155.compute-1.amazonaws.com:8080/user/profile)

#### Admin Page
If you are not an admin, attempting to access the admin page, will send you to the following 403 error page due to security issues:

[![image](https://user-images.githubusercontent.com/59325382/160707670-0e7ae085-13a9-41d2-9b73-a0f039948bf9.png)](http://ec2-35-172-114-155.compute-1.amazonaws.com:8080/admin)

However, if you have permission, you can see this page which shows all the booking list and user list!🥳

[![image](https://user-images.githubusercontent.com/59325382/160707381-444e578d-b7ea-451b-b4cb-351ab2aa31fe.png)](http://ec2-35-172-114-155.compute-1.amazonaws.com:8080/admin)


## What's the differences from v.1?

- [x] Fixed broken signup/signin function.
- [x] Upgraded the designs can prevent user errors.
- [x] Improved the web security using Spring Security 5.
- [x] Added the role for admin and the admin's dashboard. 
- [x] Automated the deployment process using Nginx and Jenkins.

## Made with

[Spring Boot](https://spring.io/projects/spring-boot), [Spring Security 5](https://spring.io/projects/spring-security), [Bootstrap 4](https://getbootstrap.com/docs/4.0/getting-started/introduction/), [AWS EC2](https://aws.amazon.com/ec2/), [MySQL](https://www.mysql.com/), [JavaScript](https://www.javascript.com/), [AJAX](https://api.jquery.com/jquery.ajax/), and ❤️

## Authors

- Denise Lee
  - Website: https://leedenise.github.io/
  - Github: https://github.com/LeeDenise
  - LinkedIn: https://www.linkedin.com/in/denise-dohui-lee/
  - Email: <deniselee.dev@gmail.com>
---
- Nova Kim
  - Website: https://novakim.me/
  - Github: https://github.com/novakim-dev
  - LinkedIn: https://www.linkedin.com/in/novakim/
  - Email: <novakim.dev@gmail.com>

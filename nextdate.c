#include <stdio.h>
int main(){
    int month,date,year,nextdate,nextmonth,nextyear;
    printf("Enter month\n");
    scanf("%d", &month);
    printf("Enter date \n");
    scanf("%d", &date);
    printf("Enter year\n");
    scanf("%d", &year);
    // leap year : 
    if(year % 100 == 0 && year % 400 == 0){
        
            if(month == 2){
                if(date == 29){
                    nextdate = 1;
                    nextmonth = 3;
                    nextyear = year;
                }
                else{
                    nextdate = date + 1;
                    nextmonth = month;
                    nextyear = year;
                }
            }
            if(month == 1 || month == 3 ||  month == 5 || month == 7 || month == 8 ||  month == 10){
                if(date == 31){
                    nextdate = 1;
                    nextmonth = month +1;
                    nextyear = year;
                }
                else{
                    nextdate = date + 1;
                    nextmonth = month;
                    nextyear = year;
                }
            }
            if(month == 12){
              if(date == 31){
                    nextdate = 1;
                    nextmonth = 1;
                    nextyear = year + 1;
                }
                else{
                    nextdate = date + 1;
                    nextmonth = month;
                    nextyear = year;  
            }
            }
            if(month == 4 || month == 6 || month == 9 || month == 11){
                if(date == 30){
                    nextdate = 1;
                    nextmonth = month + 1;
                    nextyear = year;
                }
                else{
                    nextdate = date + 1;
                    nextmonth = month;
                    nextyear = year;
                }
            }
        }
    
    if(year % 100 == 0 && year % 400 != 0){
        if(month == 2){
                if(date == 28){
                    nextdate = 1;
                    nextmonth = 3;
                    nextyear = year;
                }
                else{
                    nextdate = date + 1;
                    nextmonth = month;
                    nextyear = year;
                }
            }
            if(month == 1 || month == 3 ||  month == 5 || month == 7 || month == 8 ||  month == 10){
                if(date == 31){
                    nextdate = 1;
                    nextmonth = month +1;
                    nextyear = year;
                }
                else{
                    nextdate = date + 1;
                    nextmonth = month;
                    nextyear = year;
                }
            }
            if(month == 12){
              if(date == 31){
                    nextdate = 1;
                    nextmonth = 1;
                    nextyear = year + 1;
                }
                else{
                    nextdate = date + 1;
                    nextmonth = month;
                    nextyear = year;  
            }
            }
            if(month == 4 || month == 6 || month == 9 || month == 11){
                if(date == 30){
                    nextdate = 1;
                    nextmonth = month + 1;
                    nextyear = year;
                }
                else{
                    nextdate = date + 1;
                    nextmonth = month;
                    nextyear = year;
                }
            }
    }



if(year % 100 != 0 && year % 4 == 0){
    if(month == 2){
                if(date == 29){
                    nextdate = 1;
                    nextmonth = 3;
                    nextyear = year;
                }
                else{
                    nextdate = date + 1;
                    nextmonth = month;
                    nextyear = year;
                }
            }
            if(month == 1 || month == 3 ||  month == 5 || month == 7 || month == 8 ||  month == 10){
                if(date == 31){
                    nextdate = 1;
                    nextmonth = month +1;
                    nextyear = year;
                }
                else{
                    nextdate = date + 1;
                    nextmonth = month;
                    nextyear = year;
                }
            }
            if(month == 12){
              if(date == 31){
                    nextdate = 1;
                    nextmonth = 1;
                    nextyear = year + 1;
                }
                else{
                    nextdate = date + 1;
                    nextmonth = month;
                    nextyear = year;  
            }
            }
            if(month == 4 || month == 6 || month == 9 || month == 11){
                if(date == 30){
                    nextdate = 1;
                    nextmonth = month + 1;
                    nextyear = year;
                }
                else{
                    nextdate = date + 1;
                    nextmonth = month;
                    nextyear = year;
                }
            }
}

//non leap year :

if (year % 4 != 0){
  if(month == 2){
                if(date == 28){
                    nextdate = 1;
                    nextmonth = 3;
                    nextyear = year;
                }
                else{
                    nextdate = date + 1;
                    nextmonth = month;
                    nextyear = year;
                }
            }
            if(month == 1 || month == 3 ||  month == 5 || month == 7 || month == 8 ||  month == 10){
                if(date == 31){
                    nextdate = 1;
                    nextmonth = month +1;
                    nextyear = year;
                }
                else{
                    nextdate = date + 1;
                    nextmonth = month;
                    nextyear = year;
                }
            }
            if(month == 12){
              if(date == 31){
                    nextdate = 1;
                    nextmonth = 1;
                    nextyear = year + 1;
                }
                else{
                    nextdate = date + 1;
                    nextmonth = month;
                    nextyear = year;  
            }
            }
            if(month == 4 || month == 6 || month == 9 || month == 11){
                if(date == 30){
                    nextdate = 1;
                    nextmonth = month + 1;
                    nextyear = year;
                }
                else{
                    nextdate = date + 1;
                    nextmonth = month;
                    nextyear = year;
                }
            }  
}
printf(" %d/%d/%d", nextdate,nextmonth,nextyear);
}
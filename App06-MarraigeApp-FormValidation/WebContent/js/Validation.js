     function  validation(frm){
       alert("client side form validations...")
       //change hidden box value to "yes" indicating client side form validatios are performed
       frm.vflag.value="yes";
        // clean error messages
        document.getElementById("nameErr").innerHTML="";
        document.getElementById("ageErr").innerHTML="";
        //read form data 
        var  name=frm.pname.value;
        var age=frm.page.value;
        //write client side form validations
        if(name==""){
          document.getElementById("nameErr").innerHTML="person name is required";
          frm.pname.focus();
          return false;
        }
        
       if(age==""){
          document.getElementById("ageErr").innerHTML="person age is required";
          frm.page.focus();
          return false;
        }
        else if(isNaN(age)){
          document.getElementById("ageErr").innerHTML="person age must be a numeric value";
          frm.page.focus();
          return false;
        }
        else if(age<1  || age>125){
            document.getElementById("ageErr").innerHTML="person age must be 1 through 125 ";
           frm.page.focus();
          return false;
        }
        
       return true;
     
     }
  
  
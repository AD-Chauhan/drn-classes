<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	<style type="text/css"> 
.fa-user:before {
    content: " " !important;
}
</style>

            <section class="page--header">
               <div class="container-fluid">
                  <div class="row">
                     <div class="col-lg-6">
                        <h2 class="page--title h5">Dashboard</h2>
                        
                     </div>
                     
                  </div>
               </div>
            </section>
            <section class="main--content">
               <div class="row gutter-20">
                  <div class="col-md-4">
                     <div class="panel">
                        <div class="miniStats--panel">
                           <div class="miniStats--header bg-darker">
                             
                           </div>
                           <div class="miniStats--body">
                              <i class="miniStats--icon fa fa-user text-blue"></i> 
                              <h3 class="miniStats--title h4">Total Users</h3>
                              <p class="miniStats--num text-blue">${usersize}</p>
                           </div>
                        </div>
                     </div>
                  </div>
                 <div class="col-md-4">
                     <div class="panel">
                        <div class="miniStats--panel">
                           <div class="miniStats--header bg-darker">
                             
                           </div>
                           <div class="miniStats--body">
                              <i class="miniStats--icon fa fa-user text-blue"></i> 
                              <h3 class="miniStats--title h4">Total Videos</h3>
                              <p class="miniStats--num text-blue">${videosize}</p>
                           </div>
                        </div>
                     </div>
                  </div>
                 <div class="col-md-4">
                     <div class="panel">
                        <div class="miniStats--panel">
                           <div class="miniStats--header bg-darker">
                             
                           </div>
                           <div class="miniStats--body">
                              <i class="miniStats--icon fa fa-user text-blue"></i> 
                              <h3 class="miniStats--title h4">Total Blogs</h3>
                              <p class="miniStats--num text-blue">${blogsize}</p>
                           </div>
                        </div>
                     </div>
                  </div>
                  
                 
               </div>
               
               <div class="row gutter-20">
                  <div class="col-md-4">
                     <div class="panel">
                        <div class="miniStats--panel">
                           <div class="miniStats--header bg-darker">
                             
                           </div>
                           <div class="miniStats--body">
                              <i class="miniStats--icon fa fa-user text-blue"></i> 
                              <h3 class="miniStats--title h4">Total Questions</h3>
                              <p class="miniStats--num text-blue">${questionsize}</p>
                           </div>
                        </div>
                     </div>
                  </div>
                 <div class="col-md-4">
                     <div class="panel">
                        <div class="miniStats--panel">
                           <div class="miniStats--header bg-darker">
                             
                           </div>
                           <div class="miniStats--body">
                              <i class="miniStats--icon fa fa-user text-blue"></i> 
                              <h3 class="miniStats--title h4">Total Answers</h3>
                              <p class="miniStats--num text-blue">${answersize}</p>
                           </div>
                        </div>
                     </div>
                  </div>
                 
                  
                 
               </div>
            </section>
            
         
	

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Support forum</title>
        </head>
        
        <div class="headerFixedBar">
            <div class="row">
                <div class="col-lg-12">
                <div class="pullleft" style="margin-top: 5px;">
                    <a class="headerLogoText" href="support.jsp" ><img class="headerLogoImage" src="logo.png"> Support Forum </a>
                    
                </div>
                <div class ="pullright">
                    <a class="btn btn-primary themeButton" href="" > Logout </a>

                </div>
                </div>
            </div>
        </div>

    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 bar forumBackground">
                    <a> </a>             
                </div>
            </div>
                <div id="category_1" class="row forumBackground">
                    <a onclick="showDiscussion(1);">
                    <div class="col-lg-12 columnPad">
                        <div class="pullleft">
                        <h1> Category Name </h1>
                        </div>
                        <div class="pullright">
                            <a class ="btn btn-primary themeButton" onclick="startDiscussion(1);"> Start Discussion </a>
                    </div>
                </div>
                </a>
        </div>
            
            
            <div id="cat_new_discussion_1" class="row forumPad">
            <div class="col-lg-12"
                 <form>
                     <div class="form-group">
                          Title
                          <input type="text" name="newDiscussionTiltle" class="form-control" size="40"></input>
                          <br />
                          Content
                          <textarea style ="width:100%" class ="newDiscussionText" name="newDiscussionText" rows="10">test</textarea>
                     </div>
                </form>
            </div>
            </div>
            
            <div id="cat_discussion_1" class="row forumPad" style="display:none;">
                <div class="col-lg-12">
                    <table class="forumTable">
                        <thead>
                        <th>
                            Enquiry
                        </th>
                        <th>
                            Author
                        </th>
                        <th class="pullright">
                            Replies
                        </th>
                        </thead>
                        
                        <tr class="forumBackground">
                            <td>
                                <a>Enquiry name here</a>
                            </td>
                            <td>
                                <a>Support</a>
                            </td>
                            <td class="pullright">
                                27
                            </td>
                        </tr>
                        
                    </table>
                    
                </div>
            </div>
    </body>
    <a class ="btn btn-primary themeButton"> Submit </a>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" type="text/javascript"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>

</html>

/**
 * Created by ehc on 1/6/16.
 */
$(document).ready(function () {
  $("#searchButton").click(function () {
    var searchedName = $("#searchName").val();
      $.ajax({
        url: "/search",
        data: {name: searchedName},
        success: function (data) {
          console.log(data);
            var template;
            $('#empData').text('');
            for (var i = 0; i < data.length; i++) {
              console.log('name: ' + data[i]);
              template = +"<tr>" +
                  "<td>" + data[i].empid + "</td>" +
                  "<td>" + data[i].name + "</td>" +
                  "<td><a href='" + data[i].empid + "'>Delete</a> <a href='" + data[i].empid + "'>action</a></td>" +
                  "</tr>"
            }
     if(template!=null){
            $('#error-dialog-error-label').append(template);
          }
          else
          {
            $('#th1').text('');
            var error="<b style='color: red'>no such employee</b>";
             $("#bd").append(error);
          }
        },

          dataType: "json"
      });
  })
});
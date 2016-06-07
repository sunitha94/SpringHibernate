/**
 * Created by ehc on 1/6/16.
 */
$(document).ready(function () {
  $("#searchButton").click(function () {
    console.log('buttonClick');
    var searchedName = $("#searchName").val();
    console.log(searchedName);
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
              "<td>" + data[i].id + "</td>" +
              "<td>" + data[i].name + "</td>" +
              "<td>" + data[i].address.street +"</td>" +
              "<td>" + data[i].address.city +"</td>" +
              "<td>" + data[i].gender +"</td>" +
              "<td>" + data[i].certificatesList[0].cname +"</td>" +
              "<td><a href='/deleteEmp/" + data[i].id + "'>Delete</a> <a href='/employees/" + data[i].id + "'>update</a></td>" +
              "</tr>"
        }
        if (template != null) {
          $('#th1').show();
          $("#error-dialog-error-label").text('');
          $('#empData').append(template);
        }
        else {
          $('#th1').hide();
          var error = "<b style='color: red'>no such employee</b>";
          $("#error-dialog-error-label").append(error);
        }
      },

      dataType: "json"
    });
  })
});
// function searchProducts() {
// 	console.log("search ~~~")
//     var input = document.getElementById("search").value;
//     var searchResultsElement = document.getElementById("searchResults");
    
//     if (input.length >= 1) { // Chỉ gửi yêu cầu khi có ít nhất 3 ký tự nhập vào
//         var xhr = new XMLHttpRequest();
//         xhr.open("GET", "http://localhost:8080/api/products?search=" + input, true);
// 		xhr.setRequestHeader('Content-type', 'application/json')
//         xhr.onreadystatechange = function () {
//             if (xhr.readyState === XMLHttpRequest.DONE) {
//                 var response = JSON.parse(xhr.responseText);
//                 var searchResults = response.results;
//                 console.log(response);
//                 // Hiển thị kết quả đề xuất
//                 searchResultsElement.innerHTML = ``;
//                 var navTag = document.createElement("nav");
//                 navTag.className = "category-menu category-style-2";
//                 for (var i = 0; i < response.length; i++) {
                    
//                     var ulTag = document.createElement("ul");
//                     var liTag = document.createElement("li").text = response[i].name;
                    
//                     ulTag.appendChild(liTag);
    
//                     navTag.appendChild(ulTag);
    

                   
//                     // result.textContent = response[i].name;
                   
//                 }
//                 searchResultsElement.appendChild(navTag);
//             }
//         };
//         xhr.send();
//     } else {
//         searchResultsElement.innerHTML = ""; 
//     }
// }
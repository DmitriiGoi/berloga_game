function completeQuest() {
    var questId = $('#questQuest').children("option:selected").attr('id-value');
    var userId = $("#questUser").children("option:selected").attr('id-value');
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: "/api/quest/complete?userId=" + userId + "&questId=" + questId,
        success: function (completeQuest) {
            if (completeQuest.error == null) {
                alert('Квест успешно выполнен')
            }
        }
    });
}

function deleteQuest() {
    var questId = $('#deleteQuestButton').attr('id-value');
    $.ajax({
        type: "DELETE",
        contentType: "application/json; charset=utf-8",
        url: "/api/quest?questId=" + questId,
        success: function (deleteQuest) {
            if (deleteQuest.error == null) {
                alert('Квест успешно удален')
            }
        }
    });
}

function createQuest() {
    var payload = {
        title: $('#questName').val(),
        description: $('#questDescription').val(),
        incrementValue: $('#questBonusValue').val(),
        mainAttribute: $("#questAttribute").children("option:selected").attr('id-value'),
    };
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: "/api/quest",
        data: JSON.stringify(payload),
        dataType: "json",
        success: function (questCreate) {
            if (questCreate.error == null) {
                alert('Квест успешно создан')
            }
        }
    });
}

function deleteAchievement() {
    var achievementId = $('#deleteAchievementButton').attr('id-value');
    $.ajax({
        type: "DELETE",
        contentType: "application/json; charset=utf-8",
        url: "/api/achievement?achievementId=" + achievementId,
        success: function (deleteAchievement) {
            if (deleteAchievement.error == null) {
                alert('Достижение успешно удалено')
            }
        }
    });
}

function createAchievement() {
    var payload = {
        title: $('#achievementName').val(),
        description: $('#achievementDescription').val(),
        attributeValue: $('#achievementValue').val(),
        attribute: $("#achievementAttribute").children("option:selected").attr('id-value'),
    };
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: "/api/achievement",
        data: JSON.stringify(payload),
        dataType: "json",
        success: function (questCreate) {
            if (questCreate.error == null) {
                alert('Достижение успешно создано')
            }
        }
    });
}

function deleteUser() {
    var userId = $('#deleteUserButton').attr('id-value');
    $.ajax({
        type: "DELETE",
        contentType: "application/json; charset=utf-8",
        url: "/api/user?userId=" + userId,
        success: function (deleteUser) {
            if (deleteUser.error == null) {
                alert('Пользователь успешно удален')
            }
        }
    });
}

function createUser() {
    var payload = {
        name: $('#userName').val(),
        login: $('#userLogin').val(),
        password: $('#userPassword').val(),
    };
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: "/api/user",
        data: JSON.stringify(payload),
        dataType: "json",
        success: function (userCreate) {
            if (userCreate.error == null) {
                alert('Пользователь успешно создан')
            }
        }
    });
}
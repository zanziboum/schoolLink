// Ajoute un gestionnaire d'événements pour chaque bouton "Répondre"
var replyBtns = document.querySelectorAll('.reply-btn');
replyBtns.forEach(function(replyBtn) {
    replyBtn.addEventListener('click', function(event) {
        var comment = event.target.closest('.comment');
        var replyForm = comment.querySelector('.reply-form');
        replyForm.style.display = 'block';
    });
});

// Ajoute un gestionnaire d'événements pour chaque bouton "Annuler"
var cancelBtns = document.querySelectorAll('.cancel-btn');
cancelBtns.forEach(function(cancelBtn) {
    cancelBtn.addEventListener('click', function(event) {
        var comment = event.target.closest('.comment');
        var replyForm = comment.querySelector('.reply-form');

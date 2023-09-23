document.addEventListener('DOMContentLoaded', function () {
    const questions = document.querySelectorAll('.question');
    let currentIndex = 0;

    function showQuestion(index) {
        questions[index].classList.remove('hidden');
    }

    function hideQuestion(index) {
        questions[index].classList.add('hidden');
    }

    function nextQuestion() {
        hideQuestion(currentIndex);
        currentIndex++;
        if (currentIndex < questions.length) {
            showQuestion(currentIndex);
        } else {
            // You can redirect to a different page or display a thank you message
            alert('Thank you for completing the questionnaire!');
        }
    }

    showQuestion(currentIndex);

    questions.forEach((question, index) => {
        const input = question.querySelector('input');
        input.addEventListener('input', () => {
            if (input.value.trim() !== '') {
                nextQuestion();
            }
        });
    });
});

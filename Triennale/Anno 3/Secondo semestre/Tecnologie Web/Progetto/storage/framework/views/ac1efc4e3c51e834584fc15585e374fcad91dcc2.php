<?php if($pages->total() > 0): ?>
<div class="pagination">
    <!-- Link alla prima pagina -->
    <!-- se non mi trovo già nella 1a pagina... -->
    <?php if(!$pages->onFirstPage()): ?>
        <!-- vado alla 1a pagina -->
        <a href="<?php echo e($pages->url(1)); ?>">
            <img class="paginator-icon" src="<?php echo e(asset('assets/images/first_page.png')); ?>" alt="Prima pagina" title="Vai alla prima pagina">
        </a>
    <?php endif; ?>

    <!-- Link alla pagina precedente -->
    <!-- se non sono nella 1a pagina... -->
    <?php if($pages->currentPage() != 1): ?>
        <a href="<?php echo e($pages->previousPageUrl()); ?>">
            <img class="paginator-icon" src="<?php echo e(asset('assets/images/prev_page.png')); ?> " alt="Pagina precedente" title="Vai alla pagina precedente">
        </a>
    <?php endif; ?>

    <!-- visualizzo rispettivamente: 1° e ultimo elemento della pagina, elementi totali -->
    <?php echo e($pages->firstItem()); ?> - <?php echo e($pages->lastItem()); ?> di <?php echo e($pages->total()); ?>


    <!-- Link alla pagina successiva -->
    <!-- se ci sono ancora pagine disponibili... -->
    <?php if($pages->hasMorePages()): ?>
        <a href="<?php echo e($pages->nextPageUrl()); ?>">
            <img class="paginator-icon" src="<?php echo e(asset('assets/images/next_page.png')); ?>" alt="Pagina successiva" title="Vai alla pagina successiva">
        </a>
    <?php endif; ?>

    <!-- Link all'ultima pagina -->
    <!-- se ci sono ancora pagine, ottengo l'ultima -->
    <?php if($pages->hasMorePages()): ?>
        <a href="<?php echo e($pages->url($pages->lastPage())); ?>">
            <img class="paginator-icon" src="<?php echo e(asset('assets/images/last_page.png')); ?>" alt="Ultima pagina" title="Vai all'ultima pagina">
        </a>
    <?php endif; ?>
</div>
<?php endif; ?>
<?php /**PATH C:\Applicazioni\XAmpp\download\htdocs\ProgettoTecnologieWeb\resources\views/pagination/paginator.blade.php ENDPATH**/ ?>
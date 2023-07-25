<!DOCTYPE html>
<html lang="<?php echo e(str_replace('_', '-', app()->getLocale())); ?>">

<head>
    <!-- metadati per la visualizzazione della pagina -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- titolo della pagina -->
    <title>Offertopoli: <?php echo $__env->yieldContent('title', 'Scontati ma non scontrosi'); ?></title>

    <!-- icona della pagina (favicon) -->
    <link rel="icon" type="image/x-icon" href="<?php echo e(asset('favicon.ico')); ?>">

    <!-- inserimento fogli di stile necessari al rendering del layout della pagina -->
    <link rel="stylesheet" type="text/css" href="<?php echo e(asset('assets/css/skel.css')); ?>">
    <link rel="stylesheet" type="text/css" href="<?php echo e(asset('assets/css/containers.css')); ?>">
    <link rel="stylesheet" type="text/css" href="<?php echo e(asset('assets/css/elements.css')); ?>">
    <link rel="stylesheet" type="text/css" href="<?php echo e(asset('assets/css/forms.css')); ?>">

    <!-- importazione jQuery tramite CDN (Content Delivery Network) -->
    <!-- NOTA - gli attributi integrity e crossorigin servono per certificare l'autenticità del file inviato dal CDN -->
    <!-- e quindi per dimostrare che è completamente originale e non è stato compromesso da terzi -->
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
            crossorigin="anonymous"></script>
</head>

<body>
<header>
    <?php echo $__env->make('layouts/navbar', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?>
</header>

<main>
    <?php echo $__env->yieldContent('content'); ?>
</main>

<footer>
    <?php echo $__env->make('layouts/footer', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?>
</footer>
</body>
</html>
<?php /**PATH C:\Applicazioni\XAmpp\download\htdocs\ProgettoTecnologieWeb\resources\views/layouts/skel.blade.php ENDPATH**/ ?>
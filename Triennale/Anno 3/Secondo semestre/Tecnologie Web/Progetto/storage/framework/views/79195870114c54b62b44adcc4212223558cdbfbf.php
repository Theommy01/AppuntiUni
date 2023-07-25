

<?php $__env->startSection('title', 'Inserimento nuova F.A.Q.'); ?>

<?php $__env->startSection('content'); ?>
    <div class="container">
        <div class="panel">
            <h2>Inserisci F.A.Q.</h2>
            <br>
            <?php echo e(Form::open(array('route' => 'inserisciFAQ', 'class' => 'form-insertFAQ', 'enctype' => 'multipart/form-data'))); ?>

            <?php echo csrf_field(); ?>
            <?php echo e(Form::label('domanda', 'Domanda')); ?>

            <?php echo e(Form::text('domanda', '', ['class' => 'input', 'id' => 'domanda', 'required' => 'required', 'placeholder' => 'Domanda...'])); ?>

            <?php if($errors->first('domanda')): ?>
                <ul class="errors">
                    <?php $__currentLoopData = $errors->get('domanda'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                        <li><?php echo e($message); ?></li>
                    <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                </ul>
            <?php endif; ?>

            <?php echo e(Form::label('risposta', 'Risposta')); ?>

            <?php echo e(Form::textArea('risposta', '', ['class' => 'input', 'id' => 'risposta', 'required' => 'required', 'placeholder' => 'Risposta...'])); ?>

            <?php if($errors->first('risposta')): ?>
                <ul class="errors">
                    <?php $__currentLoopData = $errors->get('risposta'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                        <li><?php echo e($message); ?></li>
                    <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                </ul>
            <?php endif; ?>

            <?php echo e(Form::submit('Aggiungi domanda e risposta', ['class' => 'btn'])); ?>

            <?php echo e(Form::close()); ?>

            <div class="panel-buttons">
                <a class="btn btn-back" href="<?php echo e(route('gestioneFAQ')); ?>">Torna indietro</a>
            </div>
        </div>
    </div>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.skel', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Applicazioni\XAmpp\download\htdocs\ProgettoTecnologieWeb\resources\views/admin/inserisciFAQ.blade.php ENDPATH**/ ?>